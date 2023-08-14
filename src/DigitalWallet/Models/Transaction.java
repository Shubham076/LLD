package DigitalWallet.Models;

import DigitalWallet.TransactionType;

import java.time.LocalDateTime;

public class Transaction {
    private String sender;
    private String receiver;
    private LocalDateTime date;
    private Double amount;
    private TransactionType type;

    public Transaction(String sender, String receiver,  Double amount, TransactionType type) {
        this.sender = sender;
        this.receiver = receiver;
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
