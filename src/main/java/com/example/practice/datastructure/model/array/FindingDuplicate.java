package com.example.practice.datastructure.model.array;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class FindingDuplicate {


   public static void main(String[] args){
      String str = "ABCDABGH";
      StringBuilder sb = new StringBuilder();
      Set<String> elements = new HashSet<>();
      for(int i= 0; i < str.length(); i++){
         if(!elements.add(String.valueOf(str.charAt(i)))){
//            System.out.println(str.charAt(i));
            sb.append(str.charAt(i));
         }
      }
      StringJoiner joiner = new StringJoiner("-");
      joiner.add(sb);

      System.out.println(String.join("-", elements));
      System.out.println(joiner);
   }
}
