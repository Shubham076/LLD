package DigitalWallet.Interface;

import DigitalWallet.Models.Account;

public interface Observable {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(Account sender, Account receiver, Double amount);
}
