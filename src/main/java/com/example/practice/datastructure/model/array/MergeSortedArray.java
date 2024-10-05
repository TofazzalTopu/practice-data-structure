package com.example.practice.datastructure.model.array;

import java.util.Arrays;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
// representing the number of elements in nums1 and nums2 respectively.
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored
// inside the array nums1. To accommodate this, nums1 has a length of m + n,
// where the first m elements denote the elements that should be merged,
// and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

//Example 1:
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

public class MergeSortedArray {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 0, 0, 0};
        int n1 = 3;

        int arr2[] = {2, 5, 6};
        int n2 = 3;

        int arr3[] = new int[3 + n2];
        mergeArrays(arr1, arr2, 3, n2, arr3);

        System.out.println("Array after merging");
        for (int i = 0; i < n1 + n2; i++)
            System.out.print(arr3[i] + " ");

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arr3[] = new int[m + n];
        mergeArrays(nums1, nums2, m, n, arr3);

    }

    public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3) {
        int i = 0;
        int j = 0;
        int k = 0;

        // traverse the arr1 and insert its element in arr3
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }

        // now traverse arr2 and insert in arr3
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }

        // sort the whole array arr3
        Arrays.sort(arr3);
    }

}
