package com.example.practice.model.searchAndSort.binary;

import java.util.Arrays;

public class ArrayManualSorting {

    public static void main(String[] args) {
        //creating an instance of an array
        int[] arr = new int[]{78, 34, 1, 3, 90, 34, -1, -4, 6, 55, 20, -65};
//      System.out.println("Array elements after sorting:");
        descendingOrderSorting(arr);
        ascendingOrderSorting(arr);
        sortArraysInSingleLoop(arr);
    }

    public static int descendingOrderSorting(int[] arrr) {
        for (int i = 0; i < arrr.length; i++) {
            for (int j = 0; j < arrr.length; j++) {
                int temp = 0;
                if (arrr[i] >= arrr[j]) {
                    temp = arrr[i];
                    arrr[i] = arrr[j];
                    arrr[j] = temp;
                }
            }
            // System.out.println(arr[i]);
        }
        System.out.println("Array elements after descending sorting:" + Arrays.toString(arrr));

        for (int i = 0; i < arrr.length; i++) {
            if (arrr[i] > 0) {
                int finalI = i;
                if (Arrays.stream(arrr).anyMatch(a -> a != finalI)) {
                    if (i != 0) {
                        System.out.println("sorted " + i);
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    static void ascendingOrderSorting(int arrr[]) {

        for (int i = 0; i < arrr.length; i++) {
            for (int j = i + 1; j < arrr.length; j++) {
                if(arrr[i] > arrr[j]){
                    int temp = arrr[i];
                    arrr[i] = arrr[j];
                    arrr[j] = temp;
                }
            }
        }
        System.out.println("Array elements after ascending sorting:" + Arrays.toString(arrr));
    }

    public static void sortArraysInSingleLoop(int[] arr) {
        // Finding the length of array 'arr'
        int length = arr.length;
        // Sorting using a single loop
        for (int j = 0; j < length - 1; j++) {
            // Checking the condition for two simultaneous elements of the array
            if (arr[j] > arr[j + 1]) {
                // Swapping the elements.
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                // updating the value of j = -1 so after getting updated for j++
                // in the loop it becomes 0 and the loop begins from the start.
                j = -1;
            }
        }

        System.out.println("Array elements after sorting:" + Arrays.toString(arr));
    }
}
