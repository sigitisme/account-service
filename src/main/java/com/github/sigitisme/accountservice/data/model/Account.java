package com.github.sigitisme.accountservice.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_ACCOUNT")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_generator")
    @SequenceGenerator(name = "account_generator", sequenceName = "TBL_ACCOUNT_SERIAL", allocationSize = 50)
    @Column(name = "TXN_LOG_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "ACCT_NO")
    private String acctNo;

    @Column(name = "ACCT_STATUS")
    private int acctStatus;

    @Column(name = "ACCT_NAME")
    private String acctName;

    @Column(name = "ACCT_BALANCE")
    private double acctBalance;

    public boolean isActive(){
        return acctStatus == 1 ? true : false;
    }

    public Account() {}

    public Account(String acctNo, String acctName, double acctBalance, int acctStatus){
        this.acctStatus = acctStatus;
        this.acctBalance = acctBalance;
        this.acctName = acctName;
        this.acctNo = acctNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String toString() {
        return "{acctNo : " + acctNo + "acctBalance : " + acctBalance + "}";
    }

}