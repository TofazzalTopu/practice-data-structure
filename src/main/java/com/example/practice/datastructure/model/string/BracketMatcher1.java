package com.example.practice.datastructure.model.string;

import java.util.*;
import java.util.stream.Collectors;

public class BracketMatcher1 {

    static int M = 3;
    static int N = 3;


    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print("");
//        System.out.print(bracketMatcher(s.nextLine()));
        List<Integer> arr = new ArrayList<>(List.of(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33));
        System.out.println(countingSort(arr));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(112, 42, 83, 119));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(56, 125, 56, 49));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(15, 78, 101, 43));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(62, 98, 114, 108));
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.addAll(Arrays.asList(list1, list2, list3, list4));
        int arrr[] = list4.stream().mapToInt(Integer::intValue).toArray();
        flippingMatrix(matrix);
        LinkedList<Integer> list5 = new LinkedList<>(Arrays.asList(62, 98, 114, 108));
        list5.add(3);
        list5.get(1);
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {

        System.out.println(matrix);
        List<Integer> integers = new ArrayList<>();
        int dimension = 0;
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> list = matrix.get(i);
            dimension = list.size();
            for (int j = 0; j < dimension; j++) {
                integers.add(list.get(j));
            }
        }
        List<Integer> ints = matrix.stream().flatMap(e -> e.stream()).map(Integer::new).collect(Collectors.toList());
        int sum = 0;
        Collections.sort(integers);
        for (int k = 0; k < dimension; k++) {
            sum += integers.get(k);
        }
        int size = integers.size() - 1;
        int k = dimension - 1;
        while (k >= 0) {
            sum += integers.get(k);
//            System.out.println(integers.get(size));
            size--;
            k--;
        }
        return sum;
    }

    // Function to reverse
    // the given 2D arr[][]
    static void reverseColumnArray(int arr[][]) {

        // Print the arr[][] before
        // reversing every column
        printMatrix(arr);
        System.out.println();

        // Traverse each column of arr[][]
        for (int i = 0; i < N; i++) {
            // Initialise start and end index
            int start = 0;
            int end = M - 1;

            // Till start < end, swap the
            // element at start and end index
            while (start < end) {

                // Swap the element
                arr = swap(arr, start, i, end, i);

                // Increment start and decrement
                // end for next pair of swapping
                start++;
                end--;
            }
        }

        // Print the arr[][] after
        // reversing every column
        printMatrix(arr);
    }
    // Print the arr[][]
    static void printMatrix(int arr[][]) {

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
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

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> list = new ArrayList<>();

        for (Integer a : arr) {
            int occurance = Collections.frequency(arr, a);
            list.add(occurance);
        }
        return list;

    }
}
