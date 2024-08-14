package com.example.practice.datastructure.inheritance;

public interface TestOne {

    default void print() {
        System.out.println("Hi");
    }
}
