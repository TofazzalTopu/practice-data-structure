package com.example.practice.designPattern.observer;

//Step 2
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}