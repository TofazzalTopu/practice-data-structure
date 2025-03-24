package com.example.practice.datastructure.thread;

import java.util.concurrent.CountDownLatch;

//Here's a simple example of using a CountDownLatch in Java.
// This demonstrates how it can be used to coordinate threads,
// where one or more threads wait for other threads to complete their tasks before proceeding.
public class CountDownLatchExample {

    public static void main(String[] args) {
        // Create a CountDownLatch with a count of 3
        CountDownLatch latch = new CountDownLatch(3);

        // Create and start 3 worker threads
        for (int i = 1; i <= 3; i++) {
            new Thread(new Worker(latch, "Worker-" + i)).start();
        }

        System.out.println("Main thread is waiting for workers to finish...");

        try {
            // Wait until the count reaches 0
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted");
        }

        System.out.println("All workers have finished. Main thread resumes.");
    }
}

class Worker implements Runnable {
    private final CountDownLatch latch;
    private final String name;

    public Worker(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is starting work...");
        try {
            // Simulate work by sleeping
            Thread.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted");
        }
        System.out.println(name + " has finished work.");

        // Decrement the latch count
        latch.countDown();
    }
}
