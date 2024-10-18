package com.example.practice.OnlineTest.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Configuration
@EnableAutoConfiguration
public class BookSearch{
    @Autowired
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Autowired
    public RecommendationService recommendationService() {
        return new RecommendationService();
    }
}

@Service
class RecommendationService {
    @Autowired
    public BookRepository repository;

    public String recommendBook() {
        return repository.getBooks().get(0);
    }

    static void m(List<? extends List> l){

    }

    public static void main(String[] args) {
        m(new ArrayList<>());
    }
}

@Repository
class BookRepository {
    public List<String> getBooks() {
        List<String> books = new ArrayList<>();
        books.add("Book");
        books.add("Short book");
        books.add("Long book");

        return books;
    }
}


