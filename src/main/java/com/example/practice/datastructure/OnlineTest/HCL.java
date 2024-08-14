package com.example.practice.datastructure.OnlineTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HCL {

    public static void main(String[] args) {
        int[] arr = {3, 4, 11, 2, 9, 21};
        int[] arr1 = {1, 2, 4, 7};
        int[] arr2 = {-2, -1, 3, 4, 7};
        int[] arr3 = {-3, -5, 5, 4, 7};
        int n = arr.length;

        System.out.println(longestEvenSubsequence(arr1, arr1.length));
        System.out.println(getClosestToZero(arr3));
        System.out.println(sumOfTwoLargestElements(arr));
    }

    public static void c() {
        List<Integer> list = new ArrayList<>();


    }

    static int longestEvenSubsequence(int arr[], int n) {
        // Counter to store the
        // length of the subsequence
        int answer = 0;

        // Iterating through the array
        for (int i = 0; i < n; i++) {

            // Checking if the element is
            // even or not
            if (arr[i] % 2 == 0) {

                // If it is even, then
                // increment the counter
                answer++;
            }
        }
        return answer;
    }

    public static int getClosestToZero(int[] a) {
        int curr = 0;
        int near = a[0];
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            curr = a[i] * a[i];
            if (curr <= (near * near)) {
                near = Math.abs(a[i]);
            }
        }
        return near;
    }

    public static int sumOfTwoLargestElements(int[] a) {
        int sum = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if ((a[i] != a[j]) && (a[i] + a[j] > sum)) {
                    sum = a[i] + a[j];
                }
            }
        }

        return sum;
    }
}
