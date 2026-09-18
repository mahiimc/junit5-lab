package com.imc.lab3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestLifeCycleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each");
    }

    @Test
    void test1() {
        System.out.println(this + " : Test 1");
    }

    @Test
    void test2() {
        System.out.println(this + " : Test 2");
    }

    @Test
    void test3() {
        System.out.println(this + " : Test 3");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }


}
