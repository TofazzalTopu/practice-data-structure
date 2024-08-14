package com.example.practice.datastructure.inheritance;

public interface Animal {

    int length() throws IndexOutOfBoundsException;
    int getName();
    public Animal getBehaviour();

    static int test() {
        return 0;
    }

    default int defaultMethod() {
        return 0;
    }
}
