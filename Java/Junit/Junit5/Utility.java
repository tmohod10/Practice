package com.company;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Utility {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        try {
            return num1 / num2;
        }
        catch(Exception ex) {
            throw new ArithmeticException("/ by zero");
        }
    }

    public int powerOfTwo(int input) {
        return (int)Math.pow(2, input);
    }

    public boolean isPalindrome(String word) {
        return new StringBuilder(word).reverse().toString().equals(word);
    }

    public int isDivisibleByThree(int input) {
        return input % 3;
    }

    public String getMonthName(int month) {
        return LocalDate.of(2022, month, 1)
                .getMonth()
                .getDisplayName(TextStyle.FULL, Locale.US);
    }

    public String getMonthName1(int month) {
        return LocalDate.of(2022, month, 1)
                .getMonth()
                .getDisplayName(TextStyle.FULL, Locale.US);
    }

}
