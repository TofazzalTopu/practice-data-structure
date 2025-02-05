package com.example.practice.datastructure.model.model.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixProblems {

    static int M = 3;
    static int N = 3;

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(112, 42, 83, 119));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(56, 125, 56, 49));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(15, 78, 101, 43));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(62, 98, 114, 108));
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.addAll(Arrays.asList(list1, list2, list3, list4));
        int arrr[] = list4.stream().mapToInt(Integer::intValue).toArray();
        flippingMatrix(matrix);

        int twoDarray[][] = {{3, 2, 1}, {4, 5, 6}, {9, 8, 7}};
        reverseColumnArray(twoDarray);
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {

        System.out.println(matrix);
        //1
        List<Integer> integers = new ArrayList<>();
        int dimension = 0;
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> list = matrix.get(i);
            dimension = list.size();
            for (int j = 0; j < dimension; j++) {
                integers.add(list.get(j));
            }
        }
        //2
        List<Integer> ints = matrix.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
//        int sum = 0;
        Collections.sort(integers);

//        int size = integers.size() - 1;
//        int k = dimension - 1;
//        while (k >= 0) {
//            sum += integers.get(k);
//            size--;
//            k--;
//        }
        return sum;
    }

    // Given a 2D array arr[][]of integers of size M x N, where N is the number of columns and
    // M is the number of rows in the array.
    // The task is to reverse every column of the given 2D array
//    Input: arr[][] =  {{3, 2, 1}
//        {4, 5, 6},
//        {9, 8, 7}}
//
//    Output:  9 8 7
//            4 5 6
//            3 2 1
    static void reverseColumnArray(int arr[][]) {
        // Print the arr[][] before reversing every column
        printMatrix(arr);
        System.out.println();

        // Traverse each column of arr[][]
        for (int i = 0; i < N; i++) {
            // Initialise start and end index
            int start = 0;
            int end = M - 1;

            // Till start < end, swap the element at start and end index
            while (start < end) {
                // Swap the element
                arr = swap(arr, start, i, end, i);
                // Increment start and decrement end for next pair of swapping
                start++;
                end--;
            }
        }

        // Print the arr[][] after reversing every column
        printMatrix(arr);
    }

    // Print the arr[][]
    static void printMatrix(int arr[][]) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int elm = arr[i][j];
                System.out.print(elm + " ");
            }
            System.out.println();
        }
    }

    // A utility function
    // for swapping two elements.
    private static int[][] swap(int[][] arr, int start, int i, int end, int j) {
        int temp = arr[start][i];
        arr[start][i] = arr[end][j];
        arr[end][j] = temp;
        return arr;
    }
}
