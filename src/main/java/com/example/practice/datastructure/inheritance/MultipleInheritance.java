package com.example.practice.datastructure.inheritance;

public class MultipleInheritance implements TestOne, TestTwo {
    @Override
    public void print() {
        TestTwo.super.print();
    }
}
