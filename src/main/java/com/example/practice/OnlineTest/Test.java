package com.example.practice.OnlineTest;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

   public static void mainnn(String[] args) {

      String input = "This is for your reference";
      StringBuffer sb = new StringBuffer();

      String words[] = input.split(" ");
      for (int i = 0; i < words.length; i++) {
         String word = words[i];
         int length = word.length() - 1;
         int j = length;
         while (j >= 0 && j <= length) {
            sb.append(word.charAt(j));
            j--;
         }
         sb.append(" ");
      }
      System.out.println("Reverse " + sb);
   }

   public static void main(String[] args) {
      List<String> myList = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
      Map<Integer, List<String>> groupedByLength = myList.stream().collect(Collectors.groupingBy(String::length));
      // Result: {5=[apple, grape], 6=[banana], 7=[orange], 4=[kiwi]}
      System.out.println("groupedByLength: "+ groupedByLength);

      String input = "This is for your reference";
      StringBuffer sb = new StringBuffer();

      String words[] = input.split(" ");
      for (int i = 0; i < words.length; i++) {
         String word = words[i];
         int length = word.length() - 1;
         int j = length;
         while (j >= 0 && j <= length) {
            sb.append(word.charAt(j));
            j--;
         }
         sb.append(" ");
      }
      System.out.println("Reverse: " + sb);

      String str = "VVVVVTTTTKKKVV";
      Map<Character, Integer> map = new LinkedHashMap<>();
      for (int i = 0; i < str.length(); i++) {
         if (map.containsKey(str.charAt(i))) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
         } else {
            map.put(str.charAt(i), 1);
         }
      }
      System.out.println(map);

      //print approach-1
      map.entrySet().forEach((entry -> System.out.println(entry.getKey() + "" + entry.getValue())));
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
         //print approach-2
         //         System.out.println(entry.getKey() + "" + entry.getValue());///V5T4K3
      }
   }

}
