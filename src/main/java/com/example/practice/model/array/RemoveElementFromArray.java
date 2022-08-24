package com.example.practice.model.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveElementFromArray {

   public static int[] remove_Element(int[] nums, int val) {
      if (nums == null) {
         System.out.println("non-existing index");
         return nums;
      }
      String[] array = new String[0];
      List<String> stringsss = new ArrayList<>(List.of(array));
      stringsss.removeIf(s -> s.equals("q"));
      //array to arrayList
      List<Integer> arrayList = IntStream.of(nums).boxed().collect(Collectors.toList());
      System.out.println("Before Sorted:  "+arrayList);
//      arrayList.sort((p1, p2)-> p1.compareTo(p2));
      Collections.sort(arrayList);
      System.out.println("Sorted:  "+arrayList);
      //      List<Integer> arrayList = new ArrayList<>();
      // Remove the specified element
      //      arrayList.remove(index);
      //      arrayList.removeIf(integer -> integer == val);
      Integer arr[] = arrayList.stream().toArray(Integer[]::new);
      List<Integer> integers = List.of(arr);
      //      integers.removeIf(integer-> integer ==val);
      return Arrays.stream(nums).filter(d -> d != val).toArray();
      //      return integers.stream().mapToInt(Integer::intValue).toArray();
      // return the resultant array
      //      return arrayList.stream().mapToInt(Integer::intValue).toArray();
   }

   public static void main(String[] args) {
      int[] nums = { 11, 22, 33, 44, 55, 77, 66, 88, 99, 111 };
      System.out.println("Original Array: " + Arrays.toString(nums));
      int index = 111;
      System.out.println("Index at which element is to be deleted: " + index);
      nums = remove_Element(nums, index);
      System.out.println("Resultant Array: " + Arrays.toString(nums) + "\n");

      index = 2;
      System.out.println("Index at which element is to be deleted: " + index);
      nums = remove_Element(nums, index);
      System.out.println(nums.length + ", nums: " + Arrays.toString(nums));
      removeElement(nums, index);
   }

   public static int removeElement(int[] nums, int val) {
      int count = 0;

      for (int i = 0; i < nums.length; i++) {
         if (nums[i] != val) {
            nums[count++] = nums[i];
            System.out.println(Arrays.toString(nums));
         }
      }
      return count;
   }

   public static void main() {
      // define original array
      int[] tensArray = { 10, 20, 30, 40, 50, 60 };
      // Print the original array
      System.out.println("Original Array: " + Arrays.toString(tensArray));
      // the index at which the element in the array is to be removed
      int rm_index = 2;
      // display index
      System.out.println("Element to be removed at index: " + rm_index);

      // if array is empty or index is out of bounds, removal is not possible
      if (tensArray == null || rm_index < 0 || rm_index >= tensArray.length) {
         System.out.println("No removal operation can be performed!!");
      }
      // Create a proxy array of size one less than original array
      int[] proxyArray = new int[tensArray.length - 1];

      // copy all the elements in the original to proxy array except the one at index
      for (int i = 0, k = 0; i < tensArray.length; i++) {
         // check if index is crossed, continue without copying
         if (i == rm_index) continue;
         // else copy the element
         proxyArray[k++] = tensArray[i];
      }
      // Print the copied proxy array
      System.out.println("Array after removal operation: " + Arrays.toString(proxyArray));
   }

}
