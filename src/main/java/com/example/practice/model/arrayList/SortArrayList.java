package com.example.practice.model.arrayList;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.practice.model.Player;

public class SortArrayList {

   public static void main(String[] args) {
      sortArray();
      List<Integer> integerList = new ArrayList<>(List.of(10, 20, 30, 40, 50, 60, 30, 20, 10));
      Integer[] arr = integerList.toArray(new Integer[0]);
      // -1
      //      integerList.sort((p1, p2)-> p1.compareTo(p2));
      //      integerList.forEach(System.out::println);
      //      Collections.sort(integerList);
      //      System.out.println("Max " + Collections.max(integerList));
      Collections.replaceAll(integerList, 10, 15);
      // -1
      List<Integer> integers = integerList.stream().sorted().collect(Collectors.toList());
      //      List<Integer> integers = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
      //      List<Integer> integers = integerList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
      //      List<Integer> integers = integerList.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());
      //      System.out.println("\n2. Natural order of " + "ArrayList<Integer> :- \n");
      //      integers.forEach(System.out::println);

      List<Player> players = new ArrayList<>();
      players.add(new Player("a", 1));
      players.add(new Player("c", 3));
      players.add(new Player("b", 2));
      players.add(new Player("d", 2));
      List<Player> playerList = new ArrayList<>(players);

      // -1
      Collections.sort(playerList, Comparator.comparing(Player::getName).thenComparingInt(Player::getScore));
      //      playerList.forEach(p -> System.out.println(p.getName()));

      // -2
      List<Player> sortByScore = playerList.stream().sorted(Comparator.comparing(Player::getScore).reversed()).collect(Collectors.toList());
      //      sortByScore.forEach(d -> System.out.println(d.getScore()));

      // -3
      List<Player> sortByName = playerList.stream().sorted(Comparator.comparing(Player::getName)).collect(Collectors.toList());
      //      sortByName.forEach(p -> System.out.println(p.getName()));
   }

   public static int sortArray() {
//      int[] arr = new int[] { 1, 3, 6, 4, 1, 2 };
      int[] arr = new int[] { 1, 2, 3 };
      List<Integer> integerList = new ArrayList<>();
      for (int i = 0; i < arr.length; i++) {
         integerList.add(arr[i]);
      }

      Collections.sort(integerList);
      int max = Collections.max(integerList);
      int min = Collections.min(integerList);
      int minNumber = 0;
      integerList.removeIf(d -> d == 0);
      for (int i = 0; i < max; i++) {
         int number = integerList.get(i);
         if (min != number) {
            minNumber = i;
            break;
         }
         min++;

      }
      if(minNumber == 0){
         minNumber = max + 1;
      }
      return minNumber;
   }


   public int solution(int[] A) {
      // write your code in Java SE 8
      A = new int[]{1, 0, 1, 0, 1, 1};
      int a = 0;
      int b = 0;
      int n = A.length;

      for(int i = 0; i < A.length; i++){
         if(i % 2 == 0){
            if(A[i] == 1){
               a += 1;
            }
            if(A[i] == 0){
               b += 1;
            }
         } else{
            if(A[i] == 0){
               a += 1;
            }
            if(A[i] == 1){
               b += 1;
            }

         }
      }
      return min(a, b);
   }
}
