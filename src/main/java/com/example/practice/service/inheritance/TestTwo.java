package com.example.practice.service.inheritance;

public interface TestTwo {

    default void print() {
        System.out.println("Hi");
    }
}
