package DigitalWallet.Service;

import DigitalWallet.Interface.Observable;
import DigitalWallet.Interface.Observer;
import DigitalWallet.Models.Account;
import DigitalWallet.Models.Transaction;
import DigitalWallet.TransactionType;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class WalletService implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private HashMap<String, Account> accounts;

    public WalletService(){
        this.accounts = new HashMap<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Account sender, Account receiver, Double amount) {
        for(Observer o: this.observers) {
            o.update(sender, receiver, amount);
        }
    }

    public void createWallet(String name, Double amount) {
        Account account = new Account(name, amount);
        accounts.put(name, account);
        System.out.println("Wallet created for user: " + name);
    }

    public void transfer(String sender, String receiver, Double amount) {
        if (!validate(sender, receiver, amount)) {
            return;
        }

        Account source = accounts.get(sender);
        Account dest = accounts.get(receiver);
        Transaction debit = new Transaction(sender, receiver, amount, TransactionType.DEBIT);
        Transaction credit = new Transaction(sender, receiver, amount, TransactionType.CREDIT);

        source.addTransaction(debit);
        dest.addTransaction(credit);

        source.debit(amount);
        dest.credit(amount);
        notifyObservers(source, dest, amount);
        System.out.println("Transferred amount: " + amount + " from " + sender + " to " + receiver);
    }

    private boolean validate(String sender, String receiver, Double amount) {
        if (sender.equals(receiver)) {
            System.out.println("Sender and receiver accounts can't be same");
            return false;
        }

        if (!accounts.containsKey(sender)) {
            System.out.println("Invalid Sender account number");
            return false;
        }

        if (!accounts.containsKey(receiver)) {
            System.out.println("Invalid Receiver account number");
            return false;
        }

        if(amount < 0.0001) {
            System.out.println("Amount too low");
            return false;
        }

        return true;
    }

    public void showStatement(String name) {
        System.out.println("Statement: " + name);
        if (!accounts.containsKey(name)) {
            System.out.println("Account: " + name + " not found");
            return;
        }
       Account a = accounts.get(name);
        for (Transaction t: a.getTransactions()) {
            String person = t.getSender();
            if (t.getType() == TransactionType.DEBIT) {
                person = t.getReceiver();
            }
            System.out.println(person + " " + t.getType() + ": " + t.getAmount());
        }
    }

    public void overview() {
        System.out.println("-----Overview-------");
        for (String user: accounts.keySet()) {
            Double amount = accounts.get(user).getBalance();
            System.out.println(user + ": " + amount);
        }
    }

    public void offer2() {
        List<Account> allAccounts = new ArrayList<>(this.accounts.values());

        allAccounts.sort((a, b) -> {
            if (a.getTransactionCount() != b.getTransactionCount()) {
                return b.getTransactionCount() - a.getTransactionCount();
            } else if (a.getBalance() != b.getBalance()) {
                return Double.compare(b.getBalance(), a.getBalance());
            } else {
                return a.getCreatedAt().compareTo(b.getCreatedAt());
            }
        });

        if (allAccounts.size() > 0) allAccounts.get(0).credit((double)10);
        if (allAccounts.size() > 1) allAccounts.get(1).credit((double)5);
        if (allAccounts.size() > 2) allAccounts.get(2).credit((double)2);
    }

}
