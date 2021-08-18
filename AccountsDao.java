package com.company;

public interface AccountsDao {

    public void createAccount(String cardNumber, String pin);
    public void changePin(String cardNumber, String pin, String newPin);
    public long checkBalance(String cardNumber, String pin);
    public boolean isLoggedIn(String cardNumber, String pin);
}
