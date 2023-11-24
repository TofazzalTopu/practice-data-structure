package com.example.practice.model.Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

//Atomic Variable
//    The atomic variable allows us to perform an atomic operation on a variable.
//    Atomic variables minimize synchronization and help avoid memory consistency errors.
//    Hence, it ensures synchronization.
//    The atomic package provides the following five atomic variables:
//    AtomicInteger
//    AtomicLong
//    AtomicBoolean
//    AtomicIntegerArray
//    AtomicLongArray

// creating a thread by extending a thread class
public class AtomicIntegerExample extends Thread {
    // declaring an atomic variable
    private static AtomicInteger count = new AtomicInteger();

    public void run() {
        // calculating the count
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000); // putting  thread on sleep
                count.incrementAndGet(); //calling incrementAndGet() method on count variable
                System.out.println(count);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    // returning the count value
    public static AtomicInteger getCount() {
        return count;
    }

    public static void main(String[] args){
        AtomicIntegerExample at= new AtomicIntegerExample();
        at.start();
//        System.out.println(getCount());
    }
}
