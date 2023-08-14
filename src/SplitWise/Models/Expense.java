package SplitWise.Models;

import java.util.List;
import java.util.UUID;

public abstract class Expense {
    private String id;
    private User paidBy;
    private double amount;
    private List<Split> splits;

    public abstract boolean isValid();

    public Expense(User paidBy, double amount, List<Split> splits) {
        this.id = UUID.randomUUID().toString();
        this.paidBy = paidBy;
        this.amount = amount;
        this.splits = splits;
    }


    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
