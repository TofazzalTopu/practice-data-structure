package com.example.practice.datastructure.model.arrayList;

import static java.lang.Math.min;

import java.util.*;
import java.util.stream.Collectors;

import com.example.practice.datastructure.model.Player;

public class SortArrayList {

    public static void main(String[] args) {
        sortArray();
        solution();
//        sortPlayer();
    }
    public static void sortPlayer(){
        List<Integer> integerList = new ArrayList<>(List.of(10, 20, 30, 40, 50, 60, 30, 20, 10));
        Integer[] arr = integerList.toArray(new Integer[0]);
        // -1
        integerList.sort((p1, p2) -> p1.compareTo(p2));
//        integerList.forEach(System.out::println);
//        Collections.sort(integerList);
        System.out.println("M22ax " + Collections.max(integerList));
        Collections.replaceAll(integerList, 10, 15);

        // -1
        List<Integer> integers = integerList.stream().sorted().collect(Collectors.toList());
        List<Integer> a = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> b = integerList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        List<Integer> c = integerList.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());
//        System.out.println("\n2. Natural order of " + "ArrayList<Integer> :- \n");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        List<Player> players = new ArrayList<>();
        players.add(new Player("a", 1));
        players.add(new Player("c", 3));
        players.add(new Player("b", 2));
        players.add(new Player("d", 2));
        List<Player> playerList = new ArrayList<>(players);

        // -1
        Collections.sort(playerList, Comparator.comparing(Player::getName).thenComparingInt(Player::getScore));

        List<Player> p = playerList.stream().sorted(Comparator.comparing(Player::getName)).collect(Collectors.toList());
        List<Player> ps = playerList.stream().sorted(Comparator.comparing(Player::getName).reversed().thenComparing(Player::getScore).reversed()).collect(Collectors.toList());
        System.out.println(p);
        System.out.println(ps);
        // -2
        List<Player> sortByScore = playerList.stream().sorted(Comparator.comparing(Player::getScore).reversed()).collect(Collectors.toList());
        // -3
        List<Player> sortByName = playerList.stream().sorted(Comparator.comparing(Player::getName)).collect(Collectors.toList());
        List<Player> sortByNames = playerList.stream().sorted(Comparator.comparing(Player::getName).thenComparing(Player::getScore)).collect(Collectors.toList());
        System.out.println(sortByScore);
        System.out.println(sortByName);
        System.out.println(sortByNames);

        //4
        Comparator cmp = Collections.reverseOrder();
        Collections.sort(sortByScore, cmp);
    }
    public void convertToArrayList(){
        String[] geeks = {"Rahul", "Utkarsh", "Shubham", "Neelam"};
        List<String> al = new ArrayList<>(Arrays.asList(geeks));
        System.out.println(al);
    }

    public static int sortArray() {
//      int[] arr = new int[] { 1, 3, 6, 4, 1, 2 };
        Integer[] arr = new Integer[]{4, 7, 6, 1, 2, 3};

        // adding elements of array to arrayList.
//        Collections.addAll(integerList, arr);
        List<Integer> integerList = new ArrayList<>(Arrays.asList(arr));

//        Collections.sort(integerList);
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
        if (minNumber == 0) {
            minNumber = max + 1;
        }
        System.out.println(minNumber);
        return minNumber;
    }


    public static int solution() {
        // write your code in Java SE 8
        int[] A = new int[]{1, 0, 1, 0, 1, 1};
        int a = 0;
        int b = 0;
        int n = A.length;

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                if (A[i] == 1) {
                    a += 1;
                }
                if (A[i] == 0) {
                    b += 1;
                }
            } else {
                if (A[i] == 0) {
                    a += 1;
                }
                if (A[i] == 1) {
                    b += 1;
                }

            }
        }
        System.out.println(min(a,b));
        return min(a, b);
    }
}
