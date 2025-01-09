package com.example.practice.datastructure.model.jdkFeatures.jdk8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureService {

    public CompletableFuture<String> fetchDataAsync1() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data asynchronously...");
            try {
                Thread.sleep(2000); // Simulate a long-running task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Data fetched successfully!";
        });
    }

    public CompletableFuture<String> fetchDataAsync() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Data fetched";
        });
    }

    public CompletableFuture<String> processDataAsync(String data) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Processing data...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return data + " -> Processed";
        });
    }

    public CompletableFuture<String> fetchDataWithError() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data...");
            if (true) {
                throw new RuntimeException("Error occurred while fetching data!");
            }
            return "Data fetched successfully!";
        });
    }

}
