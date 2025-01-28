package com.example.practice.datastructure.thread;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        // Create a ThreadPoolExecutor with corePoolSize = 2, maximumPoolSize = 4,
        // keepAliveTime = 10 seconds, and a LinkedBlockingQueue for task queue
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // corePoolSize
                4, // maximumPoolSize
                10, // keepAliveTime
                TimeUnit.SECONDS, // time unit for keepAliveTime
                new LinkedBlockingQueue(10) // task queue
        );

        // Submit tasks to the ThreadPoolExecutor
        for (int i = 1; i <= 10; i++) {
            final int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Executing Task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulate task execution
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Task interrupted");
                }
            });
        }

        // Shut down the executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks completed");
    }
}

