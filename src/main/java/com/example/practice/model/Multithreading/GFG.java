package com.example.practice.model.Multithreading;

// driver class
public class GFG {
    // main method
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerExample t = new AtomicIntegerExample();  // creating a thread object
        Thread t1 = new Thread(t, "t1");
        t1.start(); // starting thread t1
        Thread t2 = new Thread(t, "t2");
        t2.start(); // starting thread t2
//        t1.join(); // calling join method on thread t1
//        t2.join(); // calling join method on thread t2
//        System.out.println("count=" + t.getCount());
    }
}
