package com.example.practice.model.searchAndSort.binary;

import java.util.Arrays;

public class ArrayManualSorting {

    public static void main(String[] args) {
        //creating an instance of an array
        int[] arr = new int[]{78, 34, 1, 3, 90, 34, -1, -4, 6, 55, 20, -65};
//      System.out.println("Array elements after sorting:");
//        run(arr);
        sortArray(arr);
//        sortArrays(arr);
    }

    public static int run(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = 0;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // System.out.println(arr[i]);
        }
        System.out.println("Array elements after sorting:" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                int finalI = i;
                if (Arrays.stream(arr).anyMatch(a -> a != finalI)) {
                    if (i != 0) {
                        System.out.println("sorted " + i);
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    static int[] sortArray(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Array elements after sorting:" + Arrays.toString(arr));
        return arr;
    }

    public static int[] sortArrays(int[] arr) {
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
        return arr;
    }
}
