package com.company;

import java.util.Random;

public class Account {

    private String cardNumber;
    private String pin;
    private long balance;

    public long getBalance() {
        System.out.println("Balance: " + balance);
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void createAccount() {
        Random random = new Random();
        cardNumber = Luhn.generateCardNumber();
        pin = Integer.toString(random.nextInt(9000) + 1000);
        System.out.println("Card Number is: ");
        System.out.println(cardNumber);
        System.out.println("pin is: ");
        System.out.println(pin);
    }

}
