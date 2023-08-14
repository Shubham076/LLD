package SplitWise.Models.Expenses;

import SplitWise.Models.Expense;
import SplitWise.Models.Split;
import SplitWise.Models.Splits.PercentageSplit;
import SplitWise.Models.User;

import java.util.List;

public class PercentageExpense extends Expense {
    public PercentageExpense(User paidBy, double amount, List<Split> splits) {
        super(paidBy, amount, splits);
    }

    @Override
    public boolean isValid() {
        double sum = 0.0;
        for (Split s: this.getSplits()) {
            sum += ((PercentageSplit) s).getPercentage();
        }
        return sum == 100.0;
    }
}
