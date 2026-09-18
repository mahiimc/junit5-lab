package com.imc.lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RichBankAccountTest {

    private RichBankAccount account;

    @BeforeEach
    void setup() {
        account = new RichBankAccount();
    }

    @Nested
    class DepositTest {

        @ParameterizedTest
        @CsvSource({
            "100,100",
            "200,200",
            "300,300"
        })
        @DisplayName("should increase balance when money deposited")
        void shouldAcceptValidDeposits(int deposit, int expectedBalance) {
                int balance = account.deposit(deposit);
                assertEquals(expectedBalance, balance);
        }

        @ParameterizedTest
        @ValueSource(ints = {-100,0})
        @DisplayName("should throw when negative money is deposited")
        void shouldRejectInvalidDeposits(int amount) {
           Throwable throwable =  assertThrows(IllegalArgumentException.class, () -> {
                account.deposit(amount);
            });
           assertEquals("Invalid amount.", throwable.getMessage());
        }



    }

    @Nested
    class WithdrawTest {

        @ParameterizedTest
        @CsvSource({
                "500,50,450",
                "500,500,0"
        })
        @DisplayName("should decrease the amount when money with drawn.")
        void shouldAllowValidWithDraw(int initialAmount, int withDraw, int balance) {
            account.deposit(initialAmount);
            int actualBalance = account.withdraw(withDraw);
            assertEquals(balance, actualBalance);
        }

        @ParameterizedTest
        @ValueSource(ints = {0,-100})
        @DisplayName("should not allow invalid amounts to be withdrawn")
        void shouldRejectInvalidWithDrawAmount(int withDrawAmount) {
            account.deposit(100);
            Throwable illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                account.withdraw(withDrawAmount);
            });

            assertAll( () -> assertEquals("Invalid amount.", illegalArgumentException.getMessage()),
                    () -> assertEquals(100, account.getBalance())
            );
        }

        @Test
        @DisplayName("should reject withdrawal when insufficient funds are available")
        void shouldRejectWithdrawalWhenInsufficientFunds() {
            account.deposit(100);
            Throwable illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                account.withdraw(500);
            });

            assertAll( () -> assertEquals("Insufficient funds!", illegalArgumentException.getMessage()),
                    () -> assertEquals(100, account.getBalance())
            );

        }
    }
}
