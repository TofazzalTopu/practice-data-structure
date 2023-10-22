package com.example.practice.model.arrayList;

import java.util.HashMap;
import java.util.Map;

public class Test {

   public static void main (String[] args) {
//      String s = "BABABBA";
      String s = "NAABXXAN";
//      test(s);
      characterReplacement(s, 1);
   }

   public static int test(String text){
      Map<Character, Integer> map1 = new HashMap<>();
      Map<Character, Integer> map2 = new HashMap<>(){{
         put('b', 1); put('a', 1);
         put('l', 2); put('o', 2);
         put('n', 1);
      }};

      for (char c : text.toCharArray()) {
         if (map2.containsKey(c)) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
         }
      }

      int count = text.length();

      for (char c : map2.keySet()) {
         count = Math.min(count, map1.getOrDefault(c, 0) / map2.get(c));
      }
      System.out.println(count);
      return count;

   }
   public static int characterReplacement(String s, int k) {

      int count = 0;
      int max = Integer.MIN_VALUE;
      int ptr = k;
      char ch = ' ';
      int i = 0;
      int lastStart = 0;

      while (i < s.length()) {

         if (count == 0) {
            ch = s.charAt(i);
            count = 1;
            lastStart = 0;
         } else {
            if (s.charAt(i) == ch) {
               count++;
               max = Math.max(count, max);
            } else {
               if (ptr == 0) {
                  ch = s.charAt(i);
                  ptr = k;
                  count = 0;
                  i = lastStart;
                  continue;
               }
//               if (ptr == k)
                  lastStart = i;
               ptr--;
               count++;
               max = Math.max(count, max);
            }
         }
         i++;
      }
      System.out.println("max: "+ max);
      return max;
   }
   public static int qcharacterReplacement() {
      String s = "NAABXXAN";
      int k = s.length();
      int count = 0;
      int max = Integer.MIN_VALUE;
      int ptr = s.length();
      char ch = ' ';

      for(int i = 0; i < s.length(); i++){

         // if at some time, ptr equals zero then count will also be zero
         if(count == 0){
            ch = s.charAt(i);
            count = 1;
         }
         else{
            if(s.charAt(i) == ch){
               count++;
               max = Math.max(count, max);
            }
            else{
               if(ptr == 0){
                  ch = s.charAt(i);
                  ptr = k;
                  count = 0;
                  continue;
               }
               ptr--;
               count++;
               max = Math.max(count, max);
            }
         }
      }
      System.out.println("max: "+ max);
      return max;
   }

}
