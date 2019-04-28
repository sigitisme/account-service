package com.github.sigitisme.accountservice.dto;

public class AccountDTO {

    private String acctNo;

    private int acctStatus;

    private String acctName;

    private double acctBalance;

    public AccountDTO(){}

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public int getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(int acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public double getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(double acctBalance) {
        this.acctBalance = acctBalance;
    }
}
