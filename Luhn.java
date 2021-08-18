package com.company;

import java.util.Random;

public class Luhn {

    static String generateCardNumber() {
        Random random = new Random();
        long cardNumber = 400000000000000L + (long) (Math.random() * (400000999999999L - 400000000000000L)); //random.nextLong(10000000000L) + 4000000000000000L;
        char[] digits = Long.toString(cardNumber).toCharArray();
        int[] numbers = new int[15];
        int sum = 0;
        String strDigits = new String(digits);
        for (int i = 0; i < digits.length; i++) {
            numbers[i] = Character.getNumericValue(digits[i]);
            if ((i + 1) % 2 == 1) {
                numbers[i] = numbers[i] * 2;
            }
            if (numbers[i] > 9) {
                numbers[i] = numbers[i] - 9;
            }
            sum = sum + numbers[i];
        }
        if (sum % 10 == 0) {
            return strDigits + "0";
        } else {
            return strDigits + Integer.toString(10 - (sum % 10));
        }
    }
}

