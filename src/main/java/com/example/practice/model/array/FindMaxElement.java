package com.example.practice.model.array;

import java.util.Arrays;

public class FindMaxElement {
    public static void main(String[] args) {
        int arr[] = {10, 324, 45, 90, 9808};

        // Java Stream and max to find the max and min element in array
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        System.out.println("Lowest in given array is: " + min);
        System.out.println("Largest in given array is: " + max);
    }
}
