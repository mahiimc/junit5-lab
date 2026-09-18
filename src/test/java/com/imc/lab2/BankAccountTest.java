package com.imc.lab2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    void shouldReturnUpdatedBalanceAfterDeposit() {
        bankAccount.deposit(100);
        int balance = bankAccount.getBalance();
        assertEquals(100,balance);

    }

    @Test
    void shouldAccumulateMultipleDeposits() {
        bankAccount.deposit(100);
        bankAccount.deposit(50);
        int balance = bankAccount.getBalance();
        assertEquals(150,balance);
    }

    @Test
    void shouldReturnUpdatedBalanceFromDeposit() {
        int amount = 100;
        int balance = bankAccount.deposit(amount);
        assertEquals(amount, balance);
    }

    @Test
    void shouldThrowExceptionWhenBalanceIsInsufficient() {
        bankAccount.deposit(100);
       IllegalStateException exception =  assertThrows(IllegalStateException.class, () -> {
            bankAccount.withdraw(150);
        });
       assertEquals("Insufficient balance",exception.getMessage());
    }

    @Test
    void shouldBeActiveWhenCreated() {
        boolean isActive = bankAccount.isActive();
        assertTrue(isActive);
    }

    @Test
    void shouldBeInactiveAfterAccountIsClosed() {
        bankAccount.close();
        assertFalse(bankAccount.isActive());
    }

    @Test
    void shouldUnderstandObjectEquality() {
        String first = new String("hello");
        String second = new String("hello");
        assertEquals(first,second);
        assertNotSame(first,second);
    }

    @Test
    void shouldUnderstandValueInequality() {
        int actualBalance = 100;
        assertNotEquals(200, actualBalance);
    }
}
