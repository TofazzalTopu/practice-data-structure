package com.example.practice.datastructure.model.jdkFeatures.jdk8;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    @Async
    public CompletableFuture<Void> performAsyncTaskWithCompletionTracking() {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Task started...");
            try {
                Thread.sleep(1000); // Simulate a long-running task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task finished...");
        });
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //========================================================================================================
//        CompletableFutureExample completableFutureExample = new CompletableFutureExample();
//        CompletableFuture<Void> completableFuture = completableFutureExample.performAsyncTaskWithCompletionTracking();
//        completableFuture.join();
//        System.out.println(completableFuture.thenRun(() -> System.out.println("Task completed successfully")));
//        completableFuture.thenAccept(result -> System.out.println("Result: " + result));
//        System.out.println(completableFuture.isDone());

        CompletableFutureService completableFutureService = new CompletableFutureService();
        //========================================================================================================
//        System.out.println("Requesting data...");
//        CompletableFuture<String> future = asyncService.fetchDataAsync1();
//
//        // Handle the result when the async task completes
//        System.out.println(future.get());
//        future.thenAccept(result -> System.out.println("Result: " + result));
//        // Do other work while waiting for the async task
//        System.out.println("Doing other work...");

        //========================================================================================================
        CompletableFuture<String> newFuture = completableFutureService.fetchDataAsync()
                .thenCompose(completableFutureService::processDataAsync) // Chain async processing
                .thenApply(result -> result + " -> Finalized"); // Modify the result

        // Handle the final result
        newFuture.get();
        newFuture.thenAccept(result -> System.out.println("Result: " + result));
        System.out.println(newFuture.isDone());

        //========================================================================================================
        CompletableFuture<String> future = completableFutureService.fetchDataWithError()
                .exceptionally(ex -> "Error handled: " + ex.getMessage());

        future.thenAccept(result -> System.out.println("Result: " + result));
        System.out.println("Doing other work...");

        //========================================================================================================


    }

}
