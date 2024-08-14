package com.example.practice.datastructure.common;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int n = 7;
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci_numbers(i) + " ");
        }
        printFibonacciNumbers(7);
    }
    public static int fibonacci_numbers(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci_numbers(n - 2) + fibonacci_numbers(n - 1);
        }
    }

    static void printFibonacciNumbers(int n) {
        int f1 = 0, f2 = 1, i;
        System.out.print(f1 + " ");
        if (n < 1)
            return;

        for (i = 1; i < n; i++) {
            System.out.print(f2 + " ");
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }
    }
}
