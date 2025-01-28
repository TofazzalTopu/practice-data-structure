package com.example.practice.datastructure.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // Create a CyclicBarrier for 3 threads with a barrier action
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All parties have reached the barrier. Let's proceed!");
        });

        // Create and start 3 worker threads
        for (int i = 1; i <= 3; i++) {
            int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + threadId + " is performing its task...");
                    Thread.sleep(1000 * threadId); // Simulate task execution
                    System.out.println("Thread " + threadId + " has reached the barrier.");
                    barrier.await(); // Wait at the barrier
                    System.out.println("Thread " + threadId + " is continuing its work...");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

