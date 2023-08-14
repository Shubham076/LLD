package SplitWise.Factories;

import SplitWise.Enums.ExpenseType;
import SplitWise.Models.Split;
import SplitWise.Models.Splits.EqualSplit;
import SplitWise.Models.Splits.ExactSplit;
import SplitWise.Models.Splits.PercentageSplit;

import java.util.ArrayList;
import java.util.List;

public class Splitfactory {
    public static List<Split> createSplits(String expense, String paidBy, double amount, List<String> friends, List<Double> vals) {
        List<Split> splits = new ArrayList<>();
        double amountPeruser = 0.0;
        switch (ExpenseType.valueOf(expense)) {
            case EQUAL:
                amountPeruser = amount / (friends.size() * 1.0);
                for (int i = 0; i < friends.size(); i++) {
                    splits.add(new EqualSplit(amountPeruser, friends.get(i)));
                }
                break;
            case EXACT:
                for (int i = 0; i < friends.size(); i++) {
                    amountPeruser = vals.get(i);
                    splits.add(new ExactSplit(amountPeruser, friends.get(i)));
                }
                break;
            case PERCENTAGE:
                for (int i = 0; i < friends.size(); i++) {
                    double percentage = vals.get(i);
                    amountPeruser = (amount * percentage) / 100.0;
                    splits.add(new PercentageSplit(percentage, amountPeruser, friends.get(i)));
                }
                break;
            default:
                System.out.println("Unknown expenseType");
                return null;
        }
        return splits;
    }
}
