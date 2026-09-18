package com.imc.lab1;

public class BankAccount {

    private int totalAmount = 0;

    public int deposit(int amount) {
        if ( amount <= 0 ) {
            throw new IllegalArgumentException("Please enter valid amount");
        }
        totalAmount =totalAmount + amount;
        return  totalAmount;
    }

    public int withdraw(int amount) {

        if ( amount <= 0 ) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        if ( amount > totalAmount) {
            throw  new IllegalStateException("Insufficient Funds!");
        }
        totalAmount-=amount;
        return  totalAmount;
    }

    public int getBalance() {
        return totalAmount;
    }


}
