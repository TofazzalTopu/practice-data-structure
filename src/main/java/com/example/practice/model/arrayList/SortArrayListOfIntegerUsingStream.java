package com.example.practice.model.arrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortArrayListOfIntegerUsingStream {

   public static void main(String[] args) {
      // 1. create ArrayList
      List<Integer> numbers = new ArrayList<>();

      // 1.2 add integer numbers to AL
      numbers.add(86);
      numbers.add(19);
      numbers.add(97);
      numbers.add(63);
      numbers.add(23);
      numbers.add(92);
      numbers.add(94);

      // 1.3 original ArrayList in insertion order
      System.out.println("1. Original ArrayList<Integer> "
            + "as per insertion-order :- \n");
//      numbers.forEach(System.out::println);

      // 2. Stream.sorted() - natural order
      List<Integer> sortedNumbers = numbers
            .stream()
            .sorted()
            .collect(Collectors.toList());

      // 2.1 print to console
      System.out.println("\n2. Natural order of "
            + "ArrayList<Integer> :- \n");
      sortedNumbers.forEach(System.out::println);

      // 3.  Stream.sorted() - reverse order
      List<Integer> reverseSortedNumber = numbers
            .stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

      // 3.1 print to console
      System.out.println("\n3. Reverse order of "
            + "ArrayList<Integer> :- \n");
      reverseSortedNumber.forEach(System.out::println);
   }
}
