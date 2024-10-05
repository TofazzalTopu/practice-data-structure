package com.example.practice.datastructure.model.substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindFirstOccurence {

   public static void main(String[] args) {
//      maxSetSize();
      System.out.println(isSame("a10", "10a"));
//      System.out.println(isSameText("A2Le", "2pL1"));
//      System.out.println(isSameText("a10", "10a"));
//      System.out.println(isSameText("ba1", "1Ad"));
//      strStr("hello", "ll");
   }

   //isSameText contains in two strings
   public static boolean isSame(String s, String t) {
      List<String> ls = new ArrayList<>();
      for(int i =0; i < s.length(); i++){
         ls.add(String.valueOf(s.toLowerCase().charAt(i)));
      }

      for(int i = 0; i < t.length(); i++){
         if(!ls.contains(String.valueOf(s.toLowerCase().charAt(i)))) return false;
      }

      return true;
   }

   public static boolean isSameText(String s, String t) {
      int LS = countLength(s);
      int LT = countLength(t);
      if (LT != LS)
         return false;
      Map<Integer, Character> mapLettersS = findLettersPos(s);
      Map<Integer, Character> mapLettersT = findLettersPos(t);
      boolean result = true;
      if (!checkSamePos(mapLettersS, mapLettersT))
         return false;
      result = checkSamePos(mapLettersT, mapLettersS);
      return result;
   }
   public static int countLength(String s) {
      int sumDigits = 0;
      int sumLetter = 0;
      char[] charArray = s.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
         if (Character.isLetter(charArray[i]))
            sumLetter++;
         else
            sumDigits = sumDigits + Character.getNumericValue(charArray[i]);
      }
      return sumDigits + sumLetter - 1;
   }
   public static Map<Integer, Character> findLettersPos(String s) {
      Map<Integer, Character> mapLettersPos = new HashMap<>();
      int diff = 0;
      for (int i = 0; i < s.length(); i++) {
         if (Character.isLetter(s.charAt(i)))
            if (diff > 0)
               mapLettersPos.put(i + diff - 1, s.charAt(i));
            else
               mapLettersPos.put(i, s.charAt(i));
         else {
            diff += Character.getNumericValue(s.charAt(i));
            int j = i + Character.getNumericValue(s.charAt(i));
            if(i+1 < s.length())
               mapLettersPos.put(j, s.charAt(i + 1));
            i = i + 1;
         }
      }
      return mapLettersPos;
   }
   public static boolean checkSamePos(Map<Integer, Character> map1, Map<Integer, Character> map2) {
      for (int i = 0; i < map1.keySet().size(); i++) {
         if (map1.containsKey(i) && map2.containsKey(i)) {
            if (map1.get(i).equals(map2.get(i)))
               continue;
            return false;
         }
      }
      return true;
   }


   public boolean solution(String S, String T) {
      int SLength = 0;
      int TLength = 0;
      String[] Sparts = S.split("[^\\d+]");
      String[] Tparts = T.split("[^\\d+]");

      for(int i= 0; i < Sparts.length; i++){
         if(!Sparts[i].equals("")){
            SLength += Integer.parseInt(Sparts[i]);
         }
      }

      for(int i= 0; i < Tparts.length; i++){
         if(!Tparts[i].equals("")){
            TLength += Integer.parseInt(Tparts[i]);
         }
      }
      //System.out.println("debug message" +  S.length());

      for(int i = 0; i < S.length(); i++){
         //System.out.println("this is a debug message" +  i);
         if(!Character.isDigit(S.charAt(i))){
            SLength += 1;
         }
      }

      for(int i = 0; i < T.length(); i++){
         if(!Character.isDigit(T.charAt(i))){
            TLength += 1;
         }
      }
      if(TLength != SLength){
         return false;
      }

      char[] sArray = S.toCharArray();
      char[] Sfilter = new char[SLength + 1];
      int sIndex = 0;

      for(int i = 0; i < sArray.length; i++){
         if(Character.isDigit(sArray[i])){
            sIndex += Character.getNumericValue(sArray[i]);
            System.out.println("sArray[i] message" + sArray[i]);
         } else {
            Sfilter[sIndex] = sArray[i];
            System.out.println("Sfilter[ message" + Sfilter[sIndex]);
            sIndex++;
         }
      }


      // StringBuilder sb = new StringBuilder();
      // if(S.length() % T.length() > 0) return false;
      // for(int i =0; i*T.length() < S.length(); i++){
      //   sb.append(T);
      // }

      //if(!sb.toString().equals(S)) return false;
      // System.out.println("this is a debug message" +  S.length());
      // System.out.println("this is a debug message" +  S.length() );
      // System.out.println("this is a debug message" +  sIndex);
      if(S.length() != sIndex) {
         // return false;
      }
      if(TLength == SLength && sIndex > 0) {
         return true;
      }
      return false;
   }
   public static int strStr(String haystack, String needle) {
      if (haystack == null || needle == null) {
         return -1;
      }
      int start = 0;
      int len = needle.length();
      while (start + len <= haystack.length()) {
         if (haystack.substring(start, start + len).equals(needle)) {
            return start;
         }
         start++;
      }
      return -1;
   }


   public static int maxSetSize( ) {
      List<Integer> riceBags = new ArrayList<>(List.of(1, 2, 3));
      // Write your code here
      int n = riceBags.size();
      Set<Integer> set = new HashSet<>();
      int k = 0;

      for (int i = k; i < n-1; i++){

         //set.add(riceBags.get(i));

         for (int j = i; j < n; j++){
            set.add(riceBags.get(j));
         }
         k++;
      }


      return set.size();
   }
}
