package com.example.practice.datastructure.model.jdkFeatures.jdk8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    static int count = 0;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        executorServiceExample();
        System.out.println("Total Processors: " + Runtime.getRuntime().availableProcessors());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime));
    }



    public static void executorServiceExample() {
//        int ioPoolSize = 2 * Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(10);
         for (int i = 0; i < 100; i++) {
            // System.out.println("Count: " + count);
             Runnable worker = new WorkerThread("count: "+ count++ + " " + i);
             executor.execute(worker);
         }
         executor.shutdown();
         while (!executor.isTerminated()) {
         }
         System.out.println("Finished all threads");
    }


    public static class WorkerThread implements Runnable {
        private String message;
        public WorkerThread(String s) {
            this.message = s;
        }
        public void run() {
            if(Thread.currentThread().getName().contains("thread-990")) {
                System.out.println("Executing thread-990");
//                try {
//                    System.out.println("Executing thread-990");
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
            System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
            processmessage();
            System.out.println(Thread.currentThread().getName() + " (End)");
        }
        private void processmessage() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
