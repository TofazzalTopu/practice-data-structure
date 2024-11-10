package com.example.practice.datastructure.model.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortMap {

    public static void main(String[] args) {
        sorMapByKey();
        sorMapByValue();
        mapExample();
    }

    public static void sorMapByKey() {
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
    }

    public static void mapExample(){
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
    }
    public static void sorMapByValue() {
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
        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(e-> sortedByValue.put(e.getKey(), e.getValue()));
        System.out.println("Sorted by value: " + sortedByValue);
    }
}
