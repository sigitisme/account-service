package com.github.sigitisme.accountservice.data.services;

import com.github.sigitisme.accountservice.data.model.Account;
import com.github.sigitisme.accountservice.data.model.Failure;
import com.github.sigitisme.accountservice.data.model.Transaction;
import com.github.sigitisme.accountservice.dto.BaseResponse;
import com.github.sigitisme.accountservice.dto.TransferReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

import static com.github.sigitisme.accountservice.constants.Constants.*;


@Service
public class TransferService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private FailureService failureService;

    public BaseResponse transfer(TransferReqBody transferReqBody){
        String senderAcctNo = transferReqBody.getSenderAcctNo();
        String receiverAcctNo = transferReqBody.getReceiverAcctNo();
        double amount = transferReqBody.getAmount();

        Account account1 = accountService.findByAcctNo(senderAcctNo).orElse(null);
        Account account2 = accountService.findByAcctNo(receiverAcctNo).orElse(null);

        int status = doValidation(account1, account2, amount);

        BaseResponse response = new BaseResponse();

        switch (status){
            //if failure happens, save to failure log and return

            case INVALID_ACCOUNT:
            case ACCOUNT_IS_NOT_ACTIVE:
            case INSUFFICIENT_AMOUNT:
                Failure failure = new Failure(senderAcctNo, receiverAcctNo, amount,
                        status, STATUS_DESCRIPTION.get(status));

                //save to failure db
                failureService.save(failure);
                System.out.println("Failure id : " + failure.getId());

                response.status = "1";
                response.message = failure.getStatusDesc();

                break;

            //if success, save to transaction log and save account
            case SUCCESS:
                Transaction transaction = new Transaction(senderAcctNo, receiverAcctNo, amount,
                        Calendar.getInstance().getTime(), status, STATUS_DESCRIPTION.get(status));

                //save transaction to db
                transactionService.save(transaction);

                System.out.println("Transaction id : " + transaction.getId());

                calculateTransfer(account1, account2, amount);

                //save account to db
                accountService.save(account1);
                accountService.save(account2);
                response.status = "0";
                response.message = transaction.getTxDesc();

                break;
        }

        return response;
    }

    private int doValidation(Account account1, Account account2, double amount){
        int status;

        //check whether invalid account
        if(account1 == null || account2 == null){
            status = INVALID_ACCOUNT;
        } else if(!(account1.isActive() && account2.isActive())){
            status = ACCOUNT_IS_NOT_ACTIVE;
        } else if(account1.getAcctBalance() - amount < 0) {
            status = INSUFFICIENT_AMOUNT;
        } else {
            status = SUCCESS;
        }

        return status;
    }

    private void calculateTransfer(Account account1, Account account2, double amount){
        account1.setAcctBalance(account1.getAcctBalance() - amount);
        account2.setAcctBalance(account2.getAcctBalance() + amount);
    }
}
