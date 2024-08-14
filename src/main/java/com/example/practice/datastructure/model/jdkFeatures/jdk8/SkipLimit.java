package com.example.practice.datastructure.model.jdkFeatures.jdk8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkipLimit {

    public static void main(String[] args) {
        manipulation();
    }


    public static void manipulation(){
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                .filter(i -> i % 2 == 0)
                .skip(0)
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Stream.iterate(0, i -> i + 1)
//                .filter(i -> i % 2 == 0)
                .limit(10)
                .forEach(i -> System.out.print(i + " "));

        System.out.println();
        Stream.iterate(0, i -> i + 1)
//                .filter(i -> i % 2 == 0)
                .skip(2)
                .limit(5)
//                .collect(Collectors.toList());
                .forEach(i -> System.out.print(i + " "));
    }

    //Combining skip() and limit()
    private static List<Integer> getEvenNumbers(int offset, int limit) {
        return Stream.iterate(0, i -> i + 1)
//                .filter(i -> i % 2 == 0)
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    }
}
