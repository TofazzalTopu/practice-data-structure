package com.example.practice.datastructure.model.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByCountArrayList {

   public static void main(String[] args) {

      //3 apple, 2 banana, others 1
//      List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
      List<String> items = new ArrayList<>(Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya"));
      countByClassicalLoop(items);
      Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      System.out.println(result);
   }

   public static void fizzBuzz(int n) {
      // Write your code here
      for(int i = 0; i < n; i++){
         if((i% 3 == 0) && (i% 5 == 0)){
            System.out.println("FizzBuzz");
         }
      }
   }

   public static <T> Map<T, Long> countByClassicalLoop(List<T> inputList) {
      Map<T, Long> resultMap = new HashMap<>();
      inputList.remove(2);
      for (T element : inputList) {
         if (resultMap.containsKey(element)) {
            resultMap.put(element, resultMap.get(element) + 1L);
         } else {
            resultMap.put(element, 1L);
         }
      }
      System.out.println(resultMap);

      return resultMap;
   }
}
