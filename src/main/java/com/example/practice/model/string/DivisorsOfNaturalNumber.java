package com.example.practice.model.string;

import java.util.Scanner;

public class DivisorsOfNaturalNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter required number :");
        int num = 200;

        for(int i = 1; i<=num/2; i++) {
            if(num % i == 0) {
                System.out.println(" "+i);
            }
        }
    }
}
