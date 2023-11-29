package com.example.practice.service.inheritance;

public interface TestOne {

    default void print() {
        System.out.println("Hi");
    }
}
