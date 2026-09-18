package com.imc.lab3;

public class RichBankAccount {

    private int totalAmount;

    public int deposit(int amount) {

        if (amount <= 0 ) throw new IllegalArgumentException("Invalid amount.");
        totalAmount += amount;
        return  totalAmount;
    }

    public int withdraw(int amount) {
        if ( amount <= 0 ) throw  new IllegalArgumentException("Invalid amount.");

        if ( amount <= totalAmount ) {
            totalAmount -=amount;
            return  totalAmount;
        }
        throw new IllegalArgumentException("Insufficient funds!");
    }

    public int getBalance() {
        return totalAmount;
    }
}
