package com.company;

import java.util.Scanner;

public class Service {
    Service() {
        this.run();
    }

    void run() {
        Account account = new Account();
        AccountsDaoImp accountsDaoImp = new AccountsDaoImp();
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            if (option == 1) {
                account.createAccount();
                accountsDaoImp.createAccount(account.getCardNumber(), account.getPin());
            }
            if (option == 2) {
                String cardNumber;
                String pin;
                System.out.println("Enter your card number:");
                cardNumber = scanner.next();
                System.out.println("Enter your PIN:");
                pin = scanner.next();
                if (accountsDaoImp.isLoggedIn(cardNumber, pin)) {
                    System.out.println("You have successfully logged in!");
                    account.setCardNumber(cardNumber);
                    account.setPin(pin);
                    account.setBalance(accountsDaoImp.checkBalance(cardNumber, pin));
                    while (option != 0) {
                        System.out.println("1. Balance");
                        System.out.println("2. Log out");
                        System.out.println("3. Change pin");
                        System.out.println("0. Exit");
                        option = scanner.nextInt();

                        if (option == 1) {
                            account.getBalance();
                        }
                        if (option == 2) {
                            break;
                        }
                        if (option == 3) {
                            System.out.println("Provide a new pin: ");
                            String newPin;
                            newPin = scanner.next();
                            if (newPin.length() == 4) {
                                accountsDaoImp.changePin(cardNumber, pin, newPin);
                                account.setPin(newPin);
                            } else {
                                System.out.println("The new pin must be 4 digits long.");
                            }
                        }
                    }
                } else {
                    System.out.println("Wrong card number or PIN!");
                }
            }
        } while (option != 0);
    }
}
