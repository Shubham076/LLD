package DigitalWallet.Interface;

import DigitalWallet.Models.Account;

public interface Observer {
    void update(Account sender, Account receiver, Double amount);
}
