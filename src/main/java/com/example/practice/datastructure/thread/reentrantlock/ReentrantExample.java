package com.example.practice.datastructure.thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantExample {
    private final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        ReentrantExample obj = new ReentrantExample();
        obj.methodA(); // methodA() calls methodB(), and the same thread re-enters the lock.


    }

    public void methodA() {
        lock.lock();
        try {
            System.out.println("methodA() - Holding lock");
            methodB(); // Calls another locked method
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            System.out.println("methodB() - Lock re-entered");
        } finally {
            lock.unlock();
        }
    }
}



