package com.example.practice.datastructure.model.string;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsJoiningExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        String joiner = String.join(",", names);

        // Joining with a delimiter
        String result = names.stream().collect(Collectors.joining(", "));

        System.out.println("Joined String: " + result);

        // Joining with a delimiter, prefix, and suffix
        int[] arr = {5, 1, 12, -5, 16, 2, 12, 14};
        List<String> integers = Stream.of(arr).map(String::valueOf).collect(Collectors.toList());
        String str = String.join(",", integers);
        System.out.println(MessageFormat.format("arr: {0}", str));
    }
}

