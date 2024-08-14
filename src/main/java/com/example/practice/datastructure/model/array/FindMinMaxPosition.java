package com.example.practice.datastructure.model.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class FindMinMaxPosition {

    public static int index_val(int my_arr[], int t) {
        if (my_arr == null) {
            return -1;
        }
        int len = my_arr.length;
        int i = 0;
        while (i < len) {
            if (my_arr[i] == t) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] my_arr = {34, 2, 67, 89, 99, 45, 77};
        int[] my_int_arr = {34, 2, 67, 89, 99, 45, 77};
        //approach-1
        int min_val = Collections.min(Arrays.asList(my_arr));
        int max_val = Collections.max(Arrays.asList(my_arr));
//        int min = Arrays.stream(my_int_arr).min().getAsInt();
        //approach-2
        int min = my_int_arr[0];
        int max = my_int_arr[0];
        //approach-3
        for (int i = 1; i < my_int_arr.length; i++) {
            if (my_int_arr[i] > max) {
                max = my_int_arr[i];
            } else if (my_int_arr[i] < min) {
                min = my_int_arr[i];
            }
        }
        System.out.println("The minimum value in the array is : " + min_val);
        System.out.println("The maximum value in the array is : " + max_val);
        System.out.println("The position of the minimum value is: " + index_val(my_int_arr, min_val));
        System.out.println("The position of the maximum value is: " + index_val(my_int_arr, max_val));
    }

}
