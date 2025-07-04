package com.example.practice.datastructure.thread.forkJoinPool;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExample {
    // ForkJoinPool is used for parallel processing of tasks.
    // It allows you to break down tasks into smaller subtasks and process them in parallel.
    // This is particularly useful for CPU-intensive tasks.

    //ForkJoinPool is a special thread pool designed for parallelism and is part of the Java concurrency
    // framework introduced in Java 7. It's especially useful for divide-and-conquer tasks
    // using ForkJoinTask, RecursiveTask, or RecursiveAction.

    //Key Classes
    //ForkJoinPool: The pool where tasks are submitted.
    //RecursiveTask<V>: For tasks that return a result.
    //RecursiveAction: For tasks that don’t return a result.
    // RecursiveTask returns a result


    //    Task: Calculate sum of numbers from 1 to N using ForkJoinPool
    static class SumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 10_000;
        private final long start;
        private final long end;

        public SumTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            } else {
                long mid = (start + end) / 2;
                SumTask leftTask = new SumTask(start, mid);
                SumTask rightTask = new SumTask(mid + 1, end);

                // Fork both tasks
                leftTask.fork();
                rightTask.fork();

                // Join results
                long rightResult = rightTask.join();
                long leftResult = leftTask.join();

                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        long start = 1;
        long end = 1_000_000;

        SumTask task = new SumTask(start, end);
        long result = pool.invoke(task);

        System.out.println("Sum from " + start + " to " + end + " = " + result);
    }

}
