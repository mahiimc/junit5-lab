package com.imc.lab2;

public class BankAccount {

    private int balance;
    private boolean isActive;


    public int deposit(int amount) {
        balance += amount;
        return  balance;
    }

    public  int withdraw(int amount) {
        if ( amount > balance) {
            throw  new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
        return balance;
    }

    public  int getBalance() {
        return  balance;
    }

    public boolean isActive() {
        return  isActive;
    }

    public void close() {
        this.isActive = false;
    }

}
