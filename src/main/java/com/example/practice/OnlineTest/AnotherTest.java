package com.example.practice.OnlineTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnotherTest {

    public static void main(String[] args) {
        for (int i = 44; i > 40; i--) {
            System.out.println(i);
        }
        String array[] = {"abc", "2", "0", "10"};
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));

        int x = 5, y = 10;
        swap(x, y);
        System.out.println(x + " " + y);
//        System.out.println("Hello world!".substring(12, 6));

        try {
            System.out.println("A");
            bad();
            System.out.println("B");
        } catch (Exception e) {
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
    }

    public static void bad() {
        throw new Error();
    }

    public static void swap(int a, int b) {
//        int temp=a;
//        a = b;
//        b =temp;

        b = a + b;
        a = b - a;
        b = b - a;
        System.out.println(a + " swap " + b);
    }

    void method() {
    }
}
