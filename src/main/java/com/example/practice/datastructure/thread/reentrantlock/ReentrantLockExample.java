package com.example.practice.datastructure.thread.reentrantlock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Runnable task = resource::criticalSection;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
