package com.example.practice.datastructure.OnlineTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HclTest {


    public static void main(String[] args) {
        int arr[] = {8, 5, -2, -1, 1, 2, 3, 4};
        getClosestToZero(arr);
    }

    public static int getClosestToZero(int[] a) {
        int curr = 0;
        int arr[] = new int[a.length];
        Arrays.sort(a);
        int j = 0;
        int length = a.length - 1;
        for (int i = length; i >= 0; i--) {
            arr[j] = a[i];
            j++;
        }

        int near = a[0];
        for (int i = 0; i < a.length; i++) {
            curr = a[i] * a[i];
            if (curr <= (near * near)) {
                near = a[i];
            }
        }
        System.out.println(near);
        return near;
    }
}
