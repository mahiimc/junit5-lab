package com.imc.lab2;

import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private  User user;

    @BeforeEach
    void setUp() {
        user = new User("Mahesh",27, true);
    }


    @Test
    void shouldValidateAllUserProperties() {
        assertAll(
                () -> assertEquals("Mahesh",user.getName()),
                () -> assertEquals(27, user.getAge()),
                () -> assertTrue(user.isActive())
        );
    }

    @Test
    void shouldReturnNullWhenUserDoesNotExist() {
        assertNull(user.findUser("Unkown"));
    }
    @Test
    void shouldReturnUserWhenUserExist() {
        assertNotNull(user.findUser("Mahesh"));
    }
}
