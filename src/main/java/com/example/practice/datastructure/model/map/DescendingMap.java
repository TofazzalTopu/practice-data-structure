package com.example.practice.datastructure.model.map;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DescendingMap {

    public static void main(String[] args) {
        descendingMapExample();
        addPlayer("Alice", 100);
        closestLowerHigherKeyExample();
        groupWordExample();
        caseInsensitiveOrderExample();
        reverseTreeMapExample();
        listConvertToMapExample();
        mapFlatMapExample();
        minimumKeyExample();
        maximumKeyExample();
    }

    private static void mapFlatMapExample() {
        System.out.println("Map and FlatMap Example:");
        List<List<String>> nested = List.of(List.of("a", "b"), List.of("c", "d"));

        nested.stream().map(list -> list.stream()) // Stream<Stream<String>>
                .forEach(System.out::println);

        nested.stream().flatMap(list -> list.stream()) // Stream<String>
                .forEach(System.out::println);
        System.out.println("Map and FlatMap Example END\n\n");
    }

    private static void listConvertToMapExample() {
        System.out.println("List Convert to Map Example:");
        List<String> words = List.of("apple", "banana", "apple", "orange");
        System.out.println();
        Map<String, Long> freq = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> frequency = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println("Word Frequencies: " + freq);
        System.out.println("List Convert to Map Example END\n");
    }

    private static void reverseTreeMapExample() {

    }

    private static void caseInsensitiveOrderExample() {
        System.out.println("Case Insensitive Order Example:");
        TreeMap<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        map.put("Apple", "Fruit");
        map.put("banana", "Fruit");
        map.put("APPLE", "Another Fruit"); // Overwrites "Apple"

        map.forEach((k, v) -> System.out.println(k + " = " + v));
        System.out.println("Case Insensitive Order Example END\n");
    }

    private static void groupWordExample() {
        System.out.println("Group Word Example:");
        List<String> words = List.of("apple", "bat", "ball", "cat", "elephant");

        TreeMap<Integer, List<String>> grouped = new TreeMap<>();

        for (String word : words) {
            grouped.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
        }

        grouped.forEach((length, list) -> {
            System.out.println("Length " + length + ": " + list);
        });
        System.out.println("Group Word Example END\n");

    }

    private static void closestLowerHigherKeyExample() {
        System.out.println("Closest Lower and Higher Key Example:");
        TreeMap<Integer, String> employees = new TreeMap<>();
        employees.put(1001, "Alice");
        employees.put(1003, "Bob");
        employees.put(1005, "Carol");
        employees.put(1006, "Merly");
        employees.put(1007, "Mark");

        int key = 1005;

        System.out.println("Lower: " + employees.lowerKey(key));   // 1003
        System.out.println("Higher: " + employees.higherKey(key)); // 1005
        System.out.println("closestLowerHigherKeyExample END\n");
    }


    static void addPlayer(String name, int score) {
        System.out.println("AddPlayer Example:");
        TreeMap<Integer, List<String>> leaderboard = new TreeMap<>(Comparator.reverseOrder());
        leaderboard.computeIfAbsent(score, k -> new ArrayList<>()).add(name);
        System.out.println("Added player: " + name + " with score: " + score);
        System.out.println("AddPlayer Example END\n");
    }

    private static void descendingMapExample() {
        System.out.println("Descending Map Example:");
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);
        map.forEach((k, v) -> System.out.println(k + " = " + v));
        //1. TreeMap<String, Integer> map = new TreeMap<>(Collections.reverseOrder());

        //
        System.out.println("Descending order of keys:");
        for (Map.Entry<String, Integer> entry : map.descendingMap().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        //find the max key from a map
        String maxKey = map.lastKey();
        System.out.println("Max key of the Map: " + maxKey);
        System.out.println("Min key of the Map: " + map.firstKey());
        System.out.println("Descending Map Example END\n");
    }

    public static void minimumKeyExample() {
        System.out.println("Minimum Key Example:");
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        Integer minKey = map.firstKey();
        System.out.println("Minimum key: " + minKey);
        System.out.println("Minimum Key Example END\n");
    }

    public static void maximumKeyExample() {
        System.out.println("Maximum Key Example:");
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        Integer maxKey = map.lastKey();
        System.out.println("Maximum key: " + maxKey);
        System.out.println("Maximum Key Example END\n");
    }

    public static void sortByValueDescending(){
        System.out.println("Sort By Value Descending Example:");
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 1);
        map.put("cherry", 2);

        Map<String, Integer> sortedMap = sortByValueDescending(map);
        sortedMap.forEach((k, v) -> System.out.println(k + " = " + v));
        System.out.println("Sort By Value Descending Example END\n");
    }


    //sort map by value in descending order
    public static <K, V extends Comparable<V>> Map<K, V> sortByValueDescending(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<K, V> comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }


}
