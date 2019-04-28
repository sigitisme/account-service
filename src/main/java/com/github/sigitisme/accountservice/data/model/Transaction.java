package com.github.sigitisme.accountservice.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TBL_TXN_LOG")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "txn_log_generator")
    @SequenceGenerator(name = "txn_log_generator", sequenceName = "TXN_LOG_SERIAL", allocationSize = 50)
    @Column(name = "TXN_LOG_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "SENDER_ACCT_NO")
    private String senderAcctNo;

    @Column(name = "RECEIVER_ACCT_NO")
    private String receiverAcctNo;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "TX_DATE")
    private Date txDate;

    @Column(name = "TX_STATUS")
    private int txStatus;

    @Column(name = "TX_DESC")
    private String txDesc;

    public Transaction() {}

    public Transaction(String senderAcctNo, String receiverAcctNo, double amount){
        this.senderAcctNo = senderAcctNo;
        this.receiverAcctNo = receiverAcctNo;
        this.amount = amount;
    }

    public Transaction(String senderAcctNo, String receiverAcctNo, double amount,
                       Date txDate, int txStatus, String txDesc){
        this.senderAcctNo = senderAcctNo;
        this.receiverAcctNo = receiverAcctNo;
        this.amount = amount;
        this.txDate = txDate;
        this.txStatus = txStatus;
        this.txDesc = txDesc;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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