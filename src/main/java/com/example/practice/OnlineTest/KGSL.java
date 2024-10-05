package com.example.practice.OnlineTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KGSL {

    public static void main(String[] args) {
        findTopThreeNumbers();
        System.out.println(findMultiplesOfEight());
        System.out.println("Total Threes: " + findCountsOfThree());
        printPingPong();
    }

    public static List<Integer> findTopThreeNumbers() {
        List<Integer> integerList = Arrays.asList(7, 5, 8, 3, 1, 4);
        integerList.sort(Comparator.reverseOrder());
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            newList.add(integerList.get(i));
        }
        return newList;
    }

    static int findMultiplesOfEight() {
        int count = 0;
        for (int i = 100; i < 176; i++) {
            if(i % 8 == 0){
                count++;
            }
        }

        return count;
    }

    static int findCountsOfThree() {
        int count = 0;
        for (int i = 300; i < 400; i++) {
            String[] digits = String.valueOf(i).split("");
            for(int j=0; j < digits.length; j++){
                if(Integer.parseInt(digits[j]) == 3){
                    count++;
                }
            }
        }
        return count;
    }

    static void printPingPong() {
        for (int i = 1; i <= 100; i++) {
            if((i % 3 == 0) && (i % 5 == 0)){
                System.out.println("Ping Pong");
            } else if(i % 3 == 0){
                System.out.println("Ping");
            } else if(i % 5 == 0){
                System.out.println("Pong");
            } else {
                System.out.println(i);
            }
        }
    }

}
