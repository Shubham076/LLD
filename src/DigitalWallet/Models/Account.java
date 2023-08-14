package DigitalWallet.Models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class Account {
    private String user;
    private List<Transaction> transactions;
    private Double balance;
    private String createdAt;

    public Double getBalance() {
        return balance;
    }

    public void credit(Double val) {
        this.balance = this.balance + val;
    }

    public void debit(Double val) {
        this.balance = this.balance - val;
    }

    public Account(String user, Double balance) {
        this.user = user;
        transactions = new ArrayList<>();
        this.balance = balance;
        this.createdAt = LocalDateTime.now().toString();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTransactionCount() {
        return this.transactions.size();
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction t) {
        this.transactions.add(t);
    }
}
