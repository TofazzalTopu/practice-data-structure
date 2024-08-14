package com.example.practice.datastructure.model.string;

import java.util.Arrays;

public class CumulativeSum {
    public static void main(String[] args){
        //calling the user defined method
        cumulativeSum();
    }

    //user defined method to find cumulative sum array
    public static void cumulativeSum(){
        int sum = 0;
        //Declaring the array
        int numbers[] = { 2, 9, 11, 5, 15, 6, 10 };

        // traverse through the array
        for (int i = 0; i < numbers.length; i++) {
            // find sum
            sum += numbers[i];

            // replace
            numbers[i] = sum;
        }

        //printing the result
        System.out.println("Cumulative sum is ");
        System.out.println(Arrays.toString(numbers));
    }
}
