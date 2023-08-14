package SplitWise.Factories;

import SplitWise.Enums.ExpenseType;
import SplitWise.Models.Expense;
import SplitWise.Models.Expenses.EqualExpense;
import SplitWise.Models.Expenses.ExactExpense;
import SplitWise.Models.Expenses.PercentageExpense;
import SplitWise.Models.Split;
import SplitWise.Models.User;

import java.util.List;

public class ExpenseFactory {
    public static Expense createExpense(ExpenseType expenseType, User paidBy, double amount, List<Split> splits) {
        switch (expenseType) {
            case EQUAL:
                return new ExactExpense(paidBy, amount, splits);
            case EXACT:
                return new EqualExpense(paidBy, amount, splits);
            case PERCENTAGE:
                return new PercentageExpense(paidBy, amount, splits);
            default:
                System.out.println("Unknown expenseType");
                return null;
        }
    }
}
