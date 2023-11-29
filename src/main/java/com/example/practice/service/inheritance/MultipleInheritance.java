package com.example.practice.service.inheritance;

public class MultipleInheritance implements TestOne, TestTwo {
    @Override
    public void print() {
        TestTwo.super.print();
    }
}
