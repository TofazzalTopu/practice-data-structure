package com.example.practice.datastructure.thread.forkJoinPool;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

// Task to calculate sum from 'start' to 'end'
class SimpleSumTask extends RecursiveTask<Integer> {
    int start, end;

    public SimpleSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // If range is small, compute directly
        if (end - start <= 2) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // Split the task
            int mid = (start + end) / 2;
            SimpleSumTask leftTask = new SimpleSumTask(start, mid);
            SimpleSumTask rightTask = new SimpleSumTask(mid + 1, end);

            // Run tasks in parallel
            leftTask.fork();
            int rightResult = rightTask.compute();
            int leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }


    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SimpleSumTask task = new SimpleSumTask(1, 10);

        int result = pool.invoke(task);
        System.out.println("Sum from 1 to 10 is: " + result);
    }
}
