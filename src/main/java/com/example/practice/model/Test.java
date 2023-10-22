package com.example.practice.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

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
