package com.imc.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class ParameterizedTest {

    private BankAccount bankAccount;


    @BeforeEach
    void setup() {
        bankAccount = new BankAccount();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints = {100,200,300})
    void shouldAcceptPositiveDepositAmount(int amount) {
        bankAccount.deposit(amount);
        Assertions.assertEquals(amount, bankAccount.getBalance());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @CsvSource({
            "100, 100",
            "200, 200",
            "300, 300",
            "500, 500"
    })

    void shouldAcceptPositiveDepositAmountFromCsvSource(int amount, int expectedBalance) {
        bankAccount.deposit(amount);
        Assertions.assertEquals(amount, expectedBalance);
    }

    @DisplayName("Testing method source")
    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("depositData")
    void shouldAcceptPositiveDepositAmountFromMethodSource(int deposit,   int expectedBalance) {
        bankAccount.deposit(deposit);
        Assertions.assertEquals(deposit, expectedBalance);
    }

    static Stream<Arguments> depositData() {
        return Stream.of(
                Arguments.of(100,100),
                Arguments.of(200,200),
                Arguments.of(300,300)
        );
    }

}
