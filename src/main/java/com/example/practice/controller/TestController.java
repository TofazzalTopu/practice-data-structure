package com.example.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class TestController {

//@Autowired

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, params = "", path = "")
    public void get() {

    }

    static int i;

    public static void main(String[] args) {


        System.out.println("strawberries".substring(2, 5));
        int a = 1;
        a = 2;
//        Integer b = a;
//        int c = b;
        int b = 0;
//        int c = a/b;
        String m = "hello";
        for (int i = 0; i < 10; i++) {
            System.out.println("m");
            i += 1;
        }
        System.out.println("apple".compareTo("banana"));

        List<Integer> list = new ArrayList<>();
        String s = "my name";
        StringBuilder sb = new StringBuilder();

        System.out.println(a);

    }
}
