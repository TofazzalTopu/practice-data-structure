package com.example.practice.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {

   public static void main(String[] args) {
      IntStream stream = IntStream.range(1, 100);

      List<Integer> primes = stream.filter(IntStreamExample::isPrime).boxed().collect(Collectors.toList());
      System.out.println(Arrays.stream(primes.toArray()).toArray());
   }
   public static boolean isPrime(int i)
   {
      IntPredicate isDivisible = index -> i % index == 0;
      return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
   }
}
