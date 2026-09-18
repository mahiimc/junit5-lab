package com.imc.lab2;

public  class User {

    private final String name;
    private final int age;
    private final boolean active;

    User(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    boolean isActive() {
        return active;
    }

    User findUser(String username) {
        if ( name.equals(username)) {
            return  this;
        }
        return  null;
    }
}