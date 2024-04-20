package com.example.practice.model.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestSubsequence {

    static int max_ref; // stores the LIS

    // driver program to test above functions
    public static void main(String args[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int arr1[] = {1, 2, 4, 7};
        int arr2[] = {5, 87, 99, 85, 50,93};
        int n = arr.length;
//        System.out.println("Length of lis is " + lis(arr, n) + "\n");
        //wrong answer
//        System.out.println(lengthOfLIS());
        System.out.println(longestIncreasingSubsequence(arr2, arr2.length));
//        lengthOfLIS();
    }

    /* lis() returns the length of the longest increasing subsequence in arr[] of size n */
    static int longestIncreasingSubsequence(int arr[], int c) {
        int i, j, max = 0;
        List<Integer> arrr = new ArrayList<>(Arrays.asList(5, 87, 99, 85, 50,93));
//        List<Integer> a = List.of(arr);
        int n = arrr.size();
        int lis[] = new int[n];

        Collections.sort(arrr);

        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }
        /* Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

    public static int lengthOfLIS() {
//        int nums[] = {0, 22, 9, 33, 21, 50, 41, 60, 80};
//        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
//        int nums[] = {1, 2, 4, 7};
        int nums[] = {5, 87, 99, 85, 50,93};
//        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        System.out.println(size);
        return size;
    }

    /* To make use of recursive calls, this function must return
   two things:
   1) Length of LIS ending with element arr[n-1]. We use
      max_ending_here for this purpose
   2) Overall maximum as the LIS may end with an element
      before arr[n-1] max_ref is used this purpose.
   The value of LIS of full array of size n is stored in
   *max_ref which is our final result */

    static int calculateMaxEnding(int arr[], int n) {
        // base case
        if (n == 1)
            return 1;

        // 'max_ending_here' is length of LIS ending with arr[n-1]
        int res, max_ending_here = 1;

        /* Recursively get all LIS ending with arr[0], arr[1] ...
           arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and
           max ending with arr[n-1] needs to be updated, then
           update it */
        for (int i = 1; i < n; i++) {
            res = calculateMaxEnding(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
                max_ending_here = res + 1;
        }
        // Compare max_ending_here with the overall max. And
        // update the overall max if needed
        if (max_ref < max_ending_here)
            max_ref = max_ending_here;
        // Return length of LIS ending with arr[n-1]
        return max_ending_here;
    }

    // The wrapper function for _lis()
    static int lis(int arr[], int n) {
        // The max variable holds the result
        max_ref = 1;
        // The function _lis() stores its result in max
        calculateMaxEnding(arr, n);
        // returns max
        return max_ref;
    }


}
