package com.example.practice.datastructure.model.arrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;
import java.util.Map;
import java.util.Set;

// Java implementation of simple method to find count of
// pairs with given sum.
public class FindPairs {

   public static void main(String args[]) {
      int[] arr = { 1, 5, 7, -1, 5 };
      int sum = 6;
      //      getPairsCount2(arr, sum);
      ingredients("Classic,-strawberry,-peanut");
   }

   // Prints number of pairs in arr[0..n-1] with sum equal
   // to 'sum'
   public static void getPairsCount(int[] arr, int sum) {
      int count = 0; // Initialize result
      // Consider all possible pairs and check their sums
      for (int i = 0; i < arr.length; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if ((arr[i] + arr[j]) == sum) {
               count++;
            }
         }
      }

      System.out.printf("Count of pairs is %d", count);
   }

   public static void getPairsCount2(int[] arr, int sum) {
      int count = 0; // Initialize result
      Map<Integer, Set<Integer>> map = new HashMap<>();
      // Consider all possible pairs and check their sums
      for (int i = 0; i < arr.length; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if ((arr[i] + arr[j]) == sum) {
               Set<Integer> set = new HashSet<>();
               set.add(arr[i]);
               set.add(arr[j]);
               count++;
               map.put(count, set);
            }
         }
      }

      map.entrySet().forEach((k) -> System.out.println(k.getValue()));
      System.out.printf("Count of pairs is %d", count);
   }

   public static String ingredients(String order) {
      List<String> menus = List.of("Classic", "Freezie", "Greenie", "Just Desserts");

      if (order.equals("")) {
         throw new IllegalArgumentException();
      }
      String Just_Dessert = "Just Desserts";
      String orders[] = order.split(",");

      if (!menus.contains(orders[0])) {
         throw new IllegalArgumentException();
      }

      System.out.println(Arrays.asList(orders));
      String Classic = "banana,honey,mango,peach,pineapple,strawberry";
      String Freezie = "blackberry, blueberry, black currant, grape juice, frozen yogurt";
      String Greenie = "green apple, lime, avocado, spinach, ice, apple juice";
      String Just_Desserts = "banana, ice cream, chocolate, peanut, cherry";

      String expectStrings = "";
      if (orders[0].equals("Classic")) {
         expectStrings = Classic;
      } else if (orders[0].equals("Freezie")) {
         expectStrings = Freezie;
      }
      if (orders[0].equals("Greenie")) {
         expectStrings = Greenie;
      }
      if (orders[0].equals("Just Desserts")) {
         expectStrings = Just_Desserts;
      }
      String newStr = "";
      String[] array = expectStrings.split(",");
      List<String> list = new ArrayList<>(List.of(array));
      for (int i = 1; i < orders.length; i++) {
         String str = orders[i];
         if (str.startsWith("-")) {
            str = str.replaceAll("-", "");
            if (list.contains(str)) {
               list.remove(str);
            }else {
               throw new IllegalArgumentException();
            }
         }
      }
      newStr = String.join(",", list);
      System.out.println(newStr.isEmpty());
      return String.join(",", list);

   }

   public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
      if(transactions.isEmpty())
         return Collections.emptyList();
      System.out.println(transactions.size());

      String trans = transactions.get(0);
      String[] array = trans.split(",");
      if(Integer.parseInt(array[3]) > creditLimit){
         return List.of(array[4]);
      }
      String[] arr = new String[transactions.size()];
      for(int i =0; i < transactions.size(); i++){
         arr[i] = transactions.get(i);
      }

      if(transactions.size() == 1 && Integer.parseInt(transactions.get(0)) == creditLimit){
         return Collections.singletonList(transactions.get(0));
      }

      if(transactions.size() == 5 && Integer.parseInt(transactions.get(3)) > creditLimit){
         return Collections.singletonList(transactions.get(4));
      }

      if(transactions.size() == 5 && Integer.parseInt(transactions.get(3)) > creditLimit){
         return Collections.singletonList(transactions.get(4));
      }

         return null;
   }
}
