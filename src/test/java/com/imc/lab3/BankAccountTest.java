package com.imc.lab3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount();
    }

    @Nested
    class DepositTests {

        @Test
        void shouldIncreaseBalanceAfterDeposit() {
            int updatedBalance = bankAccount.deposit(100);
            assertEquals(100, updatedBalance);
        }

        @Test
        void shouldRejectNegativeDeposit() {
            IllegalArgumentException illegalArgumentException =  assertThrows(IllegalArgumentException.class, () -> {
                bankAccount.deposit(-100);
            });
            assertEquals("Please enter valid amount",illegalArgumentException.getMessage());
        }
    }

    @Nested
    class WithdrawalTests {
        @Test
        void shouldDecreaseBalanceAfterWithdrawal() {
            bankAccount.deposit(100);
            int updatedBalance =  bankAccount.withdraw(50);
            assertEquals(50, updatedBalance);
        }

        @Test
        void shouldRejectInsufficientBalance() {
            bankAccount.deposit(100);
            IllegalStateException illegalStateException = assertThrows(IllegalStateException.class,() -> {
                bankAccount.withdraw(500);
            });

            assertEquals("Insufficient Funds!", illegalStateException.getMessage());
        }
    }


}
