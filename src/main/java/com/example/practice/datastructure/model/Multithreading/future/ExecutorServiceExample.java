package com.example.practice.datastructure.model.Multithreading.future;

import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Future<?> submit = executor.submit(new Task());
            System.out.println(submit.get());
            Future<?> future = executor.submit(callableTask);
            System.out.println(future.get());
            System.out.println(future.isDone());
            System.out.println(future.isCancelled());
        }
        executor.shutdown();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }

    static Callable<String> callableTask = () -> {
        TimeUnit.MILLISECONDS.sleep(300);
        return "Task's execution";
    };
}
