package com.example.practice.datastructure.model.sorting.bubbleSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*Consider the following version of Bubble Sort:

      for (int i = 0; i < n; i++) {

      for (int j = 0; j < n - 1; j++) {
      // Swap adjacent elements if they are in decreasing order
      if (a[j] > a[j + 1]) {
      swap(a[j], a[j + 1]);
      }
      }

      }
      Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above.
      Once sorted, print the following three lines:

      Array is sorted in numSwaps swaps., where  is the number of swaps that took place.
      First Element: firstElement, where  is the first element in the sorted array.
      Last Element: lastElement, where  is the last element in the sorted array.
      Hint: To complete this challenge, you must add a variable that keeps a running tally of all swaps that occur during execution.

      Example

      swap    a
      0       [6,4,1]
      1       [4,6,1]
      2       [4,1,6]
      3       [1,4,6]*/
public class SwapUsingBubbleSortAlgorithm {

   /*
    * Complete the 'countSwaps' function below.
    *
    * The function accepts INTEGER_ARRAY a as parameter.
    */

   public static void countSwaps(List<Integer> a) {
      Integer[] array = a.toArray(new Integer[a.size() - 1]);
      // Write your code here
      int n = array.length;
      // number of swaps for all array iterations
      int totalSwaps = 0;
      for (int i = 0; i < n; i++) {
         // number of swaps for current array iteration
         int numSwaps = 0;
         for (int j = 0; j < array.length - 1; j++) {
            if (array[j] > array[j + 1]) {
               int tmp = array[j];
               array[j] = array[j + 1];
               array[j + 1] = tmp;
               numSwaps++;
               totalSwaps++;
            }
         }
         if (numSwaps == 0) {
            System.out.printf("Array is sorted in %d swaps.\n", totalSwaps);
            System.out.printf("First Element: %d\n", array[0]);
            System.out.printf("Last Element: %d\n", array[n - 1]);
            break;
         }
      }
   }

   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(bufferedReader.readLine().trim());
      String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
      List<Integer> a = new ArrayList<>();
      for (int i = 0; i < n; i++) {
         int aItem = Integer.parseInt(aTemp[i]);
         a.add(aItem);
      }
      SwapUsingBubbleSortAlgorithm.countSwaps(a);
      bufferedReader.close();
   }

}
