package com.example.practice.datastructure.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {
    public static void main(String[] args) {
        // Create a LinkedBlockingQueue with a capacity of 5
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        // Create and start the producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String item = "Item-" + i;
                    System.out.println("Producing: " + item);
                    queue.put(item); // Blocks if the queue is full
                    Thread.sleep(500); // Simulate production delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Producer interrupted");
            }
        });

        // Create and start the consumer thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String item = queue.take(); // Blocks if the queue is empty
                    System.out.println("Consuming: " + item);
                    Thread.sleep(1000); // Simulate consumption delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Consumer interrupted");
            }
        });

        // Start both threads
        producer.start();
        consumer.start();

        // Wait for the producer to finish
        try {
            producer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the consumer after producer finishes
        consumer.interrupt();
        System.out.println("All tasks completed");
    }
}

