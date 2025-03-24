package com.example.practice.datastructure.thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void criticalSection() {
        lock.lock(); // Acquire the lock. Ensures only one thread can enter the criticalSection() at a time.
        try {
            System.out.println(Thread.currentThread().getName() + " is executing");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); // Release the lock
        }
    }
}