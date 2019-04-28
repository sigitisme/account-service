package com.github.sigitisme.accountservice.dto;

import java.util.Date;

public class TransactionDTO {

    private String senderAcctNo;

    private String receiverAcctNo;

    private double amount;

    private Date txDate;

    private int txStatus;

    private String txDesc;

    public TransactionDTO(){}

    public String getSenderAcctNo() {
        return senderAcctNo;
    }

    public void setSenderAcctNo(String senderAcctNo) {
        this.senderAcctNo = senderAcctNo;
    }

    public String getReceiverAcctNo() {
        return receiverAcctNo;
    }

    public void setReceiverAcctNo(String receiverAcctNo) {
        this.receiverAcctNo = receiverAcctNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public int getTxStatus() {
        return txStatus;
    }

    public void setTxStatus(int txStatus) {
        this.txStatus = txStatus;
    }

    public String getTxDesc() {
        return txDesc;
    }

    public void setTxDesc(String txDesc) {
        this.txDesc = txDesc;
    }
}
