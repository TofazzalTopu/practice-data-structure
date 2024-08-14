package com.example.practice.datastructure.enumExample;

import java.util.*;
import java.util.stream.Collectors;


public class EnumSetExample {
    enum Days {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        Set<Days> set = EnumSet.of(Days.TUESDAY, Days.WEDNESDAY);
        //print enum
        Arrays.stream(Days.values()).forEach(System.out::println);
        set.forEach(System.out::println);

        // Traversing elements
        Iterator<Days> iter = set.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }
}
