package com.example.practice.datastructure.model.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMap {

    public static void main(String[] args) {
        sorMapByKey();
        sorMapByValue();
        mapExample();
        mapKeyWithString();
        mapKeyWithDynamicStringVariable();
        findMaxEntry1();
        findMaxKey();
        findMaxItem();
        filterMap();
    }

    public static void sorMapByKey() {
        System.out.println("Sort Map By Key Example:");
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("orange", 2);
        map.put("banana", 5);
        map.put("grape", 1);

        // Sort the map by keys
        Map<String, Integer> sortedByKey = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> sortedByKey.put(entry.getKey(), entry.getValue()));
        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> sortedByKey.put(entry.getKey(), entry.getValue()));


        System.out.println("Sorted by key: " + sortedByKey);
        System.out.println("Sort Map By Key Example END\n");
    }

    public static void mapExample(){
        System.out.println("Map Example:");
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("apple");
        map.put(sb.toString(), 1);

        sb.append("orange");
        map.put(sb.toString(), 2);

        sb.append("banana");
        map.put(sb.toString(), 3);
        
        sb.append("grape");
        map.put(sb.toString(), 4);
        map.entrySet().forEach(e-> System.out.println(e.getKey() + " " + e.getValue()));
        System.out.println("Map Example END\n");
    }
    public static void mapKeyWithString(){
        System.out.println("Map Key With String Example:");

        String str = "apple";
        Map<String, Integer> map = new HashMap<>();
        map.put(str, 1);
        map.put(str.concat("1"), 2);
        map.put(str.concat("2"), 3);
        map.put(str.concat("3"), 4);
        map.entrySet().forEach(e-> System.out.println(e.getKey() + " " + e.getValue()));
        System.out.println("Map Key With String Example END\n");
    }
    public static void mapKeyWithDynamicStringVariable(){
        System.out.println("Map Key With Dynamic String Variable Example:");

        String str = "apple";
        Map<String, Integer> map = new HashMap<>();
        map.put(str, 1);
        str = "abc";
        map.put(str, 2);
        str = "hgfh";
        map.put(str, 3);
        str = "kjlk";
        map.put(str, 4);
        str = "kjlk";
        map.put(str, 5);
        map.entrySet().forEach(e-> System.out.println(e.getKey() + " " + e.getValue()));
        System.out.println("Map Key With Dynamic String Variable Example END\n");
    }

    public static void sorMapByValue() {
        System.out.println("Sort Map By Value Example:");
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("orange", 2);
        map.put("banana", 5);
        map.put("grape", 1);

        // Sort the map by values
        Map<String, Integer> sortedByValue = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> sortedByValue.put(entry.getKey(), entry.getValue()));
//        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .forEachOrdered(e-> sortedByValue.put(e.getKey(), e.getValue()));
        System.out.println("Sorted by value: " + sortedByValue);
        System.out.println("Sort Map By Value Example END\n");
    }

    //find max value from a map
    public static <K, V extends Comparable<V>> Map.Entry<K, V> findMaxEntry(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
    }

    public static void findMaxEntry1() {
        System.out.println("Find Max Entry Example:");
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 1);
        map.put("cherry", 2);

        Map.Entry<String, Integer> maxEntry = findMaxEntry(map);
        if (maxEntry != null) {
            System.out.println("Max Entry: " + maxEntry.getKey() + " = " + maxEntry.getValue());
        } else {
            System.out.println("Map is empty.");
        }
        System.out.println("Find Max Entry Example END\n");
    }
    public static void findMaxKey() {
        System.out.println("Find Max Key Example:");
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 1);
        map.put("cherry", 2);

        String maxKey = map.keySet().stream().max(String::compareTo).orElse(null);
        if (maxKey != null) {
            System.out.println("Max Key: " + maxKey);
        } else {
            System.out.println("Map is empty.");
        }
        //find max element from a map by key
        String minKey = map.keySet().stream().min(String::compareTo).orElse(null);
        System.out.println("Find Max Key Example END\n");
    }

    public static void findMaxItem() {
        System.out.println("Find Max Item Example:");
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("apple", 10);
        originalMap.put("banana", 5);
        originalMap.put("cherry", 15);

        Map<String, Integer> maxKeyMap = getMaxKeyEntry(originalMap);
        System.out.println("Max key entry map: " + maxKeyMap);
        System.out.println("Find Max Item Example END\n");
    }

    public static <K extends Comparable<K>, V> Map<K, V> getMaxKeyEntry(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(entry -> {
                    Map<K, V> result = new LinkedHashMap<>();
                    result.put(entry.getKey(), entry.getValue());
                    return result;
                })
                .orElseGet(Collections::emptyMap);
    }
    public static void filterMap() {
        System.out.println("Filter Map Example:");
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("apple", 10);
        originalMap.put("banana", 15);
        originalMap.put("cherry", 5);
        originalMap.put("date", 20);

        // Filter entries where value > 10
        Map<String, Integer> filteredMap = originalMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // merge function (not needed here)
                        LinkedHashMap::new // preserve order
                ));

        System.out.println("Filtered Map: " + filteredMap);
        System.out.println("Filter Map Example END\n");
    }
}
