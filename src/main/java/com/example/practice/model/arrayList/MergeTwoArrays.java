package com.example.practice.model.arrayList;

import java.util.Arrays;

public class MergeTwoArrays {

    public static void main(String[] args) {
        // first array
        int[] nums1 = {10, 20, 30, 40};
        // second array
        int[] nums2 = {50, 60, 70, 80};
        // determines length of firstArray
        int a1 = nums1.length;
        // determines length of secondArray
        int b1 = nums2.length;

        // resultant array size
        int c1 = a1 + b1;

        // create the resultant array
        int[] c = new int[c1];
        // using the pre-defined function arraycopy
        System.arraycopy(nums1, 0, c, 0, nums1.length);
        System.arraycopy(nums2, 0, c, nums1.length, nums2.length);

        int n = c.length;

        // prints the resultant array
        System.out.println(Arrays.toString(c));
        System.out.println(findMedian(c, n));
    }

    public static double findMedian(int c[], int n) {
        // First we sort the array
        Arrays.sort(c);
        // check for even case
        if (n % 2 != 0)
            return c[n / 2];
        return (double) (c[(n - 1) / 2] + c[n / 2]) / 2.0;
    }
}
