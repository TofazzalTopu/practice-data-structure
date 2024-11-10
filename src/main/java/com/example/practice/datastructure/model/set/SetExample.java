package com.example.practice.datastructure.model.set;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        System.out.println(integers);
        for (Integer i : integers) {
            System.out.println(i);
        }
        integers.stream().forEach(System.out::println);
    }
}
