package com.example.practice.datastructure.model.Multithreading.future;

import com.example.practice.datastructure.model.jdkFeatures.jdk8.ExecutorServiceExample;
import com.example.practice.entity.Product;
import com.example.practice.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ProductExecutorService {

    @Autowired
    private ProductService productService;


//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
////        executorServiceExample();
//        System.out.println("Total Processors: " + Runtime.getRuntime().availableProcessors());
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time taken: " + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime));
//    }

    public void executorServiceExample() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        long startTime = System.currentTimeMillis();

        executor.execute(() ->  executeProductList());

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime));
    }

    public List<Product> executeProductList() {
        List<Product> productList = productService.saveProductList();
        productList = productService.findAll();
        productList.forEach(product -> {
            productService.deleteProduct(product.getId());
        });
        System.out.println("Finished all threads");
        return productList;
    }
}