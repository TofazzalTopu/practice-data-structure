package com.example.practice.service.product;

import com.example.practice.entity.Product;
import com.example.practice.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Page<Product> searchProducts(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> saveProductList() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i <= 500000; i++) {
            Product product = new Product();
//            product.setId((long) i);
            product.setName("Product " + i);
            product.setDescription("Description " + i);
            product.setCreateDate(new Date());
            products.add(product);
        }
        return productRepository.saveAll(products);
    }

    public void executorServiceExample() {
        long startTime = System.currentTimeMillis();
//        List<Product> productList = executeProductList();
        List<Product> productList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(this::executeProductList);
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads " + productList.size());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime));
    }


    public List<Product> executeProductList() {
        List<Product> productList = saveProductList();
        List<Product> productList2 = productList;
        productList = findAll();
        System.out.println("Product List Size: " + productList.size());
        productList.forEach(product -> {
            deleteProduct(product.getId());
        });
        productList = findAll();
        System.out.println("Product List Size: " + productList.size());
        return productList2;
    }
}
