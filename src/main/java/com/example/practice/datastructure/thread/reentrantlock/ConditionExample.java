package com.example.practice.datastructure.thread.reentrantlock;

import java.util.concurrent.locks.*;

class ConditionExample {
    //More flexible than wait() & notify() in synchronized.
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean isReady = false;

    public void producer() throws InterruptedException {
        lock.lock();
        try {
            isReady = true;
            condition.signal();  // Notify waiting consumer
            System.out.println("producer!");
        } finally {
            lock.unlock();
        }
    }

    public void consumer() throws InterruptedException {
        lock.lock();
        try {
            while (!isReady) {
                condition.await();  // Wait until signal is received
            }
            System.out.println("Consumed!");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionExample example = new ConditionExample();
        example.producer();
    }
}

