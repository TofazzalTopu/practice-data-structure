package com.example.practice.datastructure.model.model.array.subArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KadaneAlgorithm {

    public static void main(String[] args) {
        int arr[] = {1, -2, 4, -5, 1};
        contiguousSubArrays(arr, 3);

        int[] ar = {10, 5, 2, 7, 1, 9};
        int n = ar.length;
        int k = 15;
        System.out.println("Max Length = " + lenOfLongSubarr(ar, n, k));
    }

    // Java implementation to find the length of longest subarray having sum k
    public static void contiguousSubArrays(int arr[], int targetSum) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                int sum = 0;
                List<Integer> integerList = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    //System.out.print(arr[k] + " ");
                    sum += arr[k];
                    integerList.add(arr[k]);
                }
                if (sum == targetSum) {
                    System.out.println(sum + " " + integerList);
                    return;
                }
                map.put(sum, integerList);
                System.out.println();
            }
        }
        System.out.println(map);
    }

    // function to find the length of longest
    // subarray having sum k
    static int lenOfLongSubarr(int[] arr, int n, int k) {
        int maxlength = 0;
        for (int i = 0; i < n; i++) {
            // Variable to store sum of subarrays
            int Sum = 0;
            for (int j = i; j < n; j++) {
                // Storing sum of subarrays
                Sum += arr[j];
                // if Sum equals K
                if (Sum == k) {
                    // Update maxLength
                    maxlength = Math.max(maxlength, j - i + 1);
                }
            }
        }
        // Return the maximum length
        return maxlength;
    }
}
