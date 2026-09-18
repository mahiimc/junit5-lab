package com.imc.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount();
    }

    @Test
    void shouldReturnUpdatedBalanceAfterDeposit() {
        // Act
        int actual = account.deposit(100);
        // Assert
        assertEquals(100, actual);
    }

    @Test
    void shouldRejectNegativeAmounts() {
       IllegalArgumentException exception =  Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-1);
        });

       assertEquals("Please enter valid amount", exception.getMessage());

    }

    @Test
    void shouldRejectAmountZero() {
       IllegalArgumentException illegalArgumentException =  assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        });
       assertEquals("Please enter valid amount", illegalArgumentException.getMessage());
    }

    @Test
    void shouldReturnAccumulatedBalanceAfterMultipleDeposits() {
        // Act
        account.deposit(100);
        int actual = account.deposit(150);
        // Assert
        assertEquals(250, actual);
    }

    @Test
    void shouldWithDrawValidAmount() {

        // Arrange
        account.deposit(10000);
        // Act
        int actual = account.withdraw(1000);

        //Assert
        assertEquals(9000,actual);
    }

    @Test
    void shouldRejectWithdrawOfAmountMoreThanTotalAmount() {
        // Arrange
        account.deposit(10000);

        // Act and Assert
       IllegalStateException illegalStateException =   assertThrows(IllegalStateException.class,() -> {
            account.withdraw(100000);
        });

       assertEquals("Insufficient Funds!",illegalStateException.getMessage());
    }

    @Test
    void  shouldRejectNegativeAmountWithDraw() {
        assertThrows(IllegalArgumentException.class,() -> {
            account.withdraw(-1);
        });
    }

    @Test
    void  shouldRejectZeroAmountWithDraw() {
        assertThrows(IllegalArgumentException.class,() -> {
            account.withdraw(0);
        });
    }

    @Test
    void shouldDisplayZeroBalance() {
        int amount = account.getBalance();
        assertEquals(0,amount);
    }

    @Test
    void shouldShowBalance() {
        //Arrange
        account.deposit(10000);

        //Act
        int actual = account.getBalance();

        // Assert

        assertEquals(10000, actual);
    }

    @Test
    void  withDrawTotalAmountShouldReturnZeroBalance() {
        //Arrange
        int amount = 10000;
        account.deposit(amount);

        // Act
        int balanceAmount = account.withdraw(amount);

        // Assert
        assertEquals(0,balanceAmount);

    }
}