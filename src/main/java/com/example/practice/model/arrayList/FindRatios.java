package com.example.practice.model.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class FindRatios {

   public static void main(String[] args) {
//      lonelyInteger();
      //      miniMaxSum();
      //      plusMinus();
      diagonalDifference();
   }

   public static void plusMinus() {
      List<Integer> arr = new ArrayList<Integer>(List.of(1, 1, 0, -1, -1));
      float n = arr.size();
      float pNumberCount = 0.0f;
      float nNumberCount = 0.0f;
      float zeroNumberCount = 0.0f;

      for (int i = 0; i < n; i++) {
         if (arr.get(i) > 0) {
            pNumberCount = pNumberCount + 1;
         } else if (arr.get(i) < 0) {
            nNumberCount = nNumberCount + 1;
         } else {
            zeroNumberCount = zeroNumberCount + 1;
         }
      }
      System.out.println(String.format("%.6f", (pNumberCount / n)));
      System.out.println(String.format("%.6f", (nNumberCount / n)));
      System.out.println(String.format("%.6f", (zeroNumberCount / n)));
   }

   public static void miniMaxSum() {
      List<Integer> list = List.of(256741038, 623958417, 467905213, 714532089, 938071625);
      //      List<Integer> list = List.of(1, 3, 5, 7, 9);
      ArrayList<Integer> arr = new ArrayList<Integer>(list);
      Collections.sort(arr);
      int n = arr.size();
      long min = 0;
      long max = 0;
      for (int i = 0; i < n; i++) {
         if (i < n - 1) {
            min = min + arr.get(i);
         }
         if (i > 0) {
            if (i == n - 1) {
               System.out.println(max + " " + Math.abs(arr.get(i)));
            }
            max = max + Math.abs(arr.get(i));
         }
      }
      long a = 1806395719 + 938071625;
      System.out.println(a);
      System.out.println(min + " " + max);
   }

   public static int lonelyInteger() {
      // Write your code here
      List<Integer> list = List.of(1, 2, 3, 4, 3, 2, 1);
      ArrayList<Integer> arr = new ArrayList<Integer>(list);
      Collections.sort(arr);
      int n = arr.size();
      long min = 0;
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
         if (map.containsKey(arr.get(i))) {
            map.put(arr.get(i), arr.get(i) + 1);
         } else {
            map.put(arr.get(i), 1);
         }
      }
      AtomicReference<Integer> value = new AtomicReference<>(0);
      int b = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         if (entry.getValue() == 1) {
            b = entry.getKey();
         }
      }
      Iterator it;

      map.entrySet().forEach((k) -> {
         if (k.getValue() == 1) {
            System.out.println(k.getKey());
            value.set(k.getValue());
         }
      });
      return b;
   }

   //   public static int diagonalDifference(List<List<Integer>> list) {

   /**
    * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
    * For example, the square matrix  is shown below:
    * 1 2 3
    * 4 5 6
    * 9 8 9
    */
   public static int diagonalDifference() {
      ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 2, 3));
      ArrayList<Integer> list2 = new ArrayList<>(List.of(4, 5, 6));
      ArrayList<Integer> list3 = new ArrayList<>(List.of(9, 8, 9));
      List<List<Integer>> list = new ArrayList<>();
      list.add(list1);
      list.add(list2);
      list.add(list3);

      int rSum = 0;
      int lSum = 0;
      int i = 0;
      int j = 0;
      int dif = 0;
      for (i = 0; i < list.size(); i++) {
         for (j = 0; j < list.get(0).size(); j++) {
            if (i == j) {
               lSum += list.get(i).get(j);
            }
            if ((i + j) == (list.get(0).size() - 1)) {
               rSum += list.get(i).get(j);
            }
         }
      }
      System.out.println("rSum: "+ rSum);
      System.out.println("lSum: "+ lSum);
      dif = Math.abs(rSum - lSum);
      System.out.println("dif: "+ dif);
      return dif;
   }

   public static void mainn(String[] args) {
      ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
         ArrayList<Integer> intList = new ArrayList<>(); // This creates a new list for each row.
         for (int k = 0; k < 5; k++) {
            intList.add(k);
         }
         mainList.add(intList);
      }
      for (int row = 0; row < mainList.size(); row++) {
         for (int col = 0; col < mainList.get(0).size(); col++) {
            System.out.print(mainList.get(row).get(col) + ",");
         }
         System.out.println("");
      }
   }

}
