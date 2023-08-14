package SplitWise.Models.Splits;

import SplitWise.Models.Split;

public class PercentageSplit extends Split {
    private double percentage;

    public PercentageSplit(double percentage, double amount, String user) {
        super(amount, user);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}
