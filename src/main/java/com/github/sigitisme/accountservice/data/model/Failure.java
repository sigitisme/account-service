package com.github.sigitisme.accountservice.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_FAILURE_LOG")
public class Failure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "failure_log_generator")
    @SequenceGenerator(name = "failure_log_generator", sequenceName = "FAILURE_LOG_SERIAL", allocationSize = 50)
    @Column(name = "FAILURE_LOG_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "SENDER_ACCT_NO")
    private String senderAcctNo;

    @Column(name = "RECEIVER_ACCT_NO")
    private String receiverAcctNo;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "STATUS_DESC")
    private String statusDesc;

    public Failure() {}

    public Failure(String senderAcctNo, String receiverAcctNo, double amount, int status, String statusDesc){
        this.senderAcctNo = senderAcctNo;
        this.receiverAcctNo = receiverAcctNo;
        this.amount = amount;
        this.status = status;
        this.statusDesc = statusDesc;
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