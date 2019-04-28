package com.github.sigitisme.accountservice.dto;

public class FailureDTO {

    private String senderAcctNo;

    private String receiverAcctNo;

    private double amount;

    private int status;

    private String statusDesc;

    public FailureDTO(){}

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
