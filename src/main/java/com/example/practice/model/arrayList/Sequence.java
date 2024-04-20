package com.example.practice.model.arrayList;

import java.io.IOException;
import java.util.Arrays;

public class Sequence {

    static int f(int idx, int prev_idx, int n, int a[],
                 int[][] dp) {
        if (idx == n) {
            return 0;
        }

        if (dp[idx][prev_idx + 1] != -1) {
            return dp[idx][prev_idx + 1];
        }

        int notTake = 0 + f(idx + 1, prev_idx, n, a, dp);
        int take = Integer.MIN_VALUE;
        if (prev_idx == -1 || a[idx] > a[prev_idx]) {
            take = 1 + f(idx + 1, idx, n, a, dp);
        }

        return dp[idx][prev_idx + 1]
                = Math.max(take, notTake);
    }

    // The wrapper function for _lis()
    static int lis(int arr[], int n) {
        // The function _lis() stores its result in max
        int dp[][] = new int[n + 1][n + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return f(0, -1, n, arr, dp);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        int a[] = {5, 87, 99, 85, 50, 93};
        int n = a.length;
        int arr[] = {11, -22, 43, -54, 66, 5};

        int N = arr.length;
        System.out.println(lengthOfLIS(a));
        // Function call
//        EvenLIS(arr);
        // Function call
//        System.out.println("Length of lis is " + lis(a, n));
    }

    static void EvenLIS(int arr[]) {

        // Length of arr
        int n = arr.length;

        // Stores length of
        // required subsequence
        int lis[] = new int[n];
        Arrays.fill(lis, 1);

        // Traverse the array
        for (int i = 1; i < n; i++) {

            // Traverse prefix of current
            // array element
            for (int j = 0; j < i; j++) {

                // Check if the subsequence is
                // LIS and have even absolute
                // difference of adjacent pairs
                if (Math.abs(arr[i]) > Math.abs(arr[j]) &&
                        Math.abs(arr[i]) % 2 == 0 &&
                        Math.abs(arr[j]) % 2 == 0 &&
                        lis[i] < lis[j] + 1)

                    // Update lis[]
                    lis[i] = lis[j] + 1;
            }
        }

        // Stores maximum length
        int maxlen = 0;

        // Find the length of longest
        // absolute even subsequence
        for (int i = 0; i < n; i++)
            maxlen = Math.max(maxlen, lis[i]);

        // Return the maximum length of
        // absolute even subsequence
        System.out.println(maxlen);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    public static void m() throws IOException, Exception {

    }
}
