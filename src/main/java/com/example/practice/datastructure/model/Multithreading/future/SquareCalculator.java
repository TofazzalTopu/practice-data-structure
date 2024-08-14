package com.example.practice.datastructure.model.Multithreading.future;

import java.util.concurrent.*;

public class SquareCalculator {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }

    public static void moreMultithreadingWithThreadPools() throws InterruptedException, ExecutionException {
        SquareCalculator squareCalculator = new SquareCalculator();

        Future<Integer> future1 = squareCalculator.calculate(10);
        Future<Integer> future2 = squareCalculator.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();
        System.out.println(result1 + " and " + result2);
//        squareCalculator.shutdown();
    }
    public static void future() throws InterruptedException, ExecutionException, TimeoutException {
        Future<Integer> future = new SquareCalculator().calculate(10);

        while(!future.isDone()) {
            System.out.println("Calculating...");
            java.lang.Thread.sleep(300);
        }
        Integer result = future.get();
        Integer resultt = future.get(500, TimeUnit.MILLISECONDS);
        System.out.println("result " + result);
        System.out.println("resultt " + resultt);

        boolean canceled = future.cancel(true);
    }

    public static void main(String[] str) throws ExecutionException, InterruptedException, TimeoutException {
//        future();
        moreMultithreadingWithThreadPools();

    }
}

