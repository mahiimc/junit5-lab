package com.imc.lab2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountAssessmentTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    void shouldCreateNewAccountWithZeroBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void shouldReturnUpdatedBalanceAfterDeposit() {
        int amount = 100;
        int balance = bankAccount.deposit(amount);
        assertAll(
                () -> assertEquals(amount, balance),
                () -> assertEquals(amount, bankAccount.getBalance())
        );
    }

    @Test
    void shouldReturnUpdatedBalanceAfterWithdraw() {
        bankAccount.deposit(100);

        int balance = bankAccount.withdraw(30);

        assertAll(
                () -> assertEquals(70, balance),
                () -> assertEquals(70, bankAccount.getBalance())
        );
    }

    @Test
    void shouldThrowExceptionWhenBalanceInsufficient() {
        IllegalStateException illegalStateException =  assertThrows(IllegalStateException.class,
                () -> bankAccount.withdraw(100));
        assertEquals("Insufficient balance", illegalStateException.getMessage());
    }


}
