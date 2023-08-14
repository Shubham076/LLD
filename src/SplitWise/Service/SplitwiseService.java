package SplitWise.Service;
import SplitWise.Enums.ExpenseType;
import SplitWise.Factories.ExpenseFactory;
import SplitWise.Factories.Splitfactory;
import SplitWise.Models.Expense;
import SplitWise.Models.Split;
import SplitWise.Models.User;

import java.util.*;

public class SplitwiseService {
    private List<Expense> expenses;
    private Map<String, User> users;
    private Map<String, Map<String, Double>> balanceSheet;
    public List<Expense> getExpenses() {
        return expenses;
    }

    public SplitwiseService() {
        this.expenses = new ArrayList<>();
        users = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public Set<String> getUsers() {
        return users.keySet();
    }

    public void addUser(String name) {
        this.users.put(name, new User(name));
        this.balanceSheet.put(name, new HashMap<>());
        System.out.println("User: " + name + " is added to the service");
    }

    public void addExpense(String expType, String paidby, double amount, List<String> friends, List<Double> vals) {
        List<Split> splits = Splitfactory.createSplits(expType, paidby, amount, friends, vals);
        if (splits == null) {
            return;
        }
        ExpenseType expenseType = ExpenseType.valueOf(expType);

        User user = users.getOrDefault(paidby, null);
        if (user != null) {
            Expense expense = ExpenseFactory.createExpense(expenseType, user, amount, splits);
            boolean isValid = expense.isValid();

            if (!isValid) {
                System.out.println("Expense: " + expense.getId() + " is not valid");
            }

            expenses.add(expense);
            for (Split split: splits) {
                String paidTo = split.getUser();

                Map<String, Double> paidByBalanceSheet = balanceSheet.get(paidby);
                Map<String, Double> paidToBalanceSheet = balanceSheet.get(paidTo);

                paidByBalanceSheet.putIfAbsent(paidTo, 0.0);
                paidToBalanceSheet.putIfAbsent(paidby, 0.0);

                paidByBalanceSheet.put(paidTo, paidByBalanceSheet.get(paidTo) + split.getAmount());
                paidToBalanceSheet.put(paidby, paidToBalanceSheet.get(paidby) - split.getAmount());
            }

        } else {
            System.out.println("User: " + paidby + " not found");
        }
    }

    public void show() {
        for (String s: balanceSheet.keySet()) {
            showBalances(s);
        }
        System.out.println("--------------------");
    }

    public void showBalances(String id) {
        User user = users.getOrDefault(id, null);
        if  (user != null) {
            boolean isEmpty = true;
            for (Map.Entry<String, Double> userBalance : balanceSheet.get(id).entrySet()) {
                if (userBalance.getValue() != 0) {
                    isEmpty = false;
                    printBalance(id, userBalance.getKey(), userBalance.getValue());
                }
            }
            if (isEmpty) {
                System.out.println("No balances");
            }
        } else {
            System.out.println("User: " + user + " not found");
        }
    }

    private void printBalance(String user1, String user2, double amount) {
        if (amount < 0) {
            System.out.println(user1 + " owes " + user2 + ": " + Math.abs(amount));
        }
    }
}
