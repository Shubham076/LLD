package SplitWise.Models.Expenses;

import SplitWise.Models.Expense;
import SplitWise.Models.Split;
import SplitWise.Models.Splits.PercentageSplit;
import SplitWise.Models.User;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(User paidBy, double amount, List<Split> splits) {
        super(paidBy, amount, splits);
    }

    @Override
    public  boolean isValid() {
        double sum = 0.0;
        for (Split s: this.getSplits()) {
            sum += s.getAmount();
        }
        return sum == this.getAmount();
    }
}
