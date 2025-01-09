package com.example.practice.datastructure.model.sorting;

import java.util.Arrays;

public class InsertionSort {

    void insertionSort(int array[]) {
        int size = array.length;
        System.out.println(Arrays.toString(array));

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
                System.out.println("Middle " + Arrays.toString(array));
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
            System.out.println("End " + Arrays.toString(array));
        }
    }

    // Driver code
    public static void main(String args[]) {
        int[] data = { 9, 5, 1, 4, 3 };
        InsertionSort is = new InsertionSort();
        is.insertionSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
