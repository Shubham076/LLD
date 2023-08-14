package SplitWise.Models;

public abstract class Split {
    private double amount;
    private String user;

    public Split(double amount, String user) {
        this.amount = amount;
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
