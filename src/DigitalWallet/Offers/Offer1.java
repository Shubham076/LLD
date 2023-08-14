package DigitalWallet.Offers;

import DigitalWallet.Interface.Observer;
import DigitalWallet.Models.Account;
import DigitalWallet.Models.Transaction;
import DigitalWallet.TransactionType;

public class Offer1 implements Observer {

    @Override
    public void update(Account sender, Account receiver, Double amount) {
        if (sender.getBalance().equals(receiver.getBalance())) {
            sender.credit((double)10);
            receiver.credit((double)10);
            Transaction t1 = new Transaction("OFFER1", sender.getUser(), amount, TransactionType.CREDIT);
            Transaction t2 = new Transaction("OFFER1", receiver.getUser(), amount, TransactionType.CREDIT);
            sender.addTransaction(t1);
            receiver.addTransaction(t2);
        }
    }
}
