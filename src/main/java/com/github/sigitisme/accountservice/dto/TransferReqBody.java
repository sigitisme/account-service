package com.github.sigitisme.accountservice.dto;

import javax.validation.constraints.NotNull;

public class TransferReqBody {

    @NotNull
    private String senderAcctNo;

    @NotNull
    private String receiverAcctNo;

    @NotNull
    private double amount;

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
}
