package com.example.practice.datastructure.model.array;


import java.util.Arrays;

public class RotateArrayElements {

    public static void rotate(int[] nums, int k) {
        int length = nums.length - 1;
        int j = 0;
        while (j < k) {
            int temp = nums[length];
            for (int i = length; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
    }
}
