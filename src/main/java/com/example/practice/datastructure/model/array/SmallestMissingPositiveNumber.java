package com.example.practice.datastructure.model.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestMissingPositiveNumber {

    /* Utility function that puts all non-positive
        (0 and negative) numbers on left side of
        arr[] and return count of such numbers */
    static int segregate(int arr[], int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    /* Find the smallest positive missing
       number in an array that contains
       all positive integers */
    static int findMissingPositive(int arr[], int size) {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start from 0 and positive numbers start from 1
        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0) arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which is positive
        for (i = 0; i < size; i++)
            if (arr[i] > 0) return i + 1; // 1 is added because indexes start from 0

        return size + 1;
    }

    /* Find the smallest positive missing
       number in an array that contains
       both positive and negative integers */
    static int findMissing(int arr[], int size) {
        // First separate positive and negative numbers
        int shift = segregate(arr, size);
        int arr2[] = new int[size - shift];
        int j = 0;
        for (int i = shift; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {1, 0, 3, 10, 2, -10, -20};
        int[] ar = new int[]{-2, -1, 0, 1, 3, 6, 4, 1, 2};
        int arr_size = arr.length;
//        int missing = findMissing(arr, arr_size);
//        System.out.println("The smallest positive missing number is " + missing);
        System.out.println("The smallest positive missing number is " + findMissingPositive(ar));
        findSmallestMissing(arr);
    }


    public static int findMissingPositive(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        int smallestPositiveMissing = Integer.MAX_VALUE;
        int maxValue = 0;
        int minValue = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > 0 && arr[j] > maxValue) {
                maxValue = arr[j];
            } else if (arr[j] < minValue) {
                minValue = arr[j];
            }
        }
        int i = minValue; // 0 if positive array element only
        while (i <= maxValue) {
            if (i > 0 && !list.contains(i) && i < smallestPositiveMissing) {
                smallestPositiveMissing = i;
            }
            i++;
        }
        System.out.println("'smallestPositiveMissing: " + smallestPositiveMissing);
        return smallestPositiveMissing;
    }

    public static void findSmallestMissing(int[] arrr) {
        int arr[] = {4, 6, 100, 1, 0, 3, 10, 2, 10, 20};
        int min = arr[0];
        int max = arr[0];
        int missing = min;
        List<Integer> integers = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (Integer a : integers) {
            if (a < min) {
                min = a;
            } else if (a > min && a < max) {
                if (!integers.contains(missing + 1)) {
                    missing = missing + 1;
                }
            } else if (a > max) {
                max = a;
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < min) {
//                min = arr[i];
//            } else if (arr[i] > min && arr[i] < max) {
//                missing = missing + 1;
//            } else if (arr[i] > max) {
//                max = arr[i];
//            }
//        }

        System.out.println("min: " + min + " Max: " + max + " Missing: " + missing);
    }

}
