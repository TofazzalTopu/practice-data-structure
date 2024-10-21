package com.example.practice.datastructure.model.map;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapElements {

    public static void main(String[] args) {
        sortMapElements();
        removeMapElements();
        System.out.println();
    }

    public static void removeMapElements() {
        Map<String, String> map2 = new HashMap<>();
        map2.put("a", "1");
        map2.put("x", "0");
        map2.put("c", "3");
        map2.put("b", "2");
        map2.put("d", "4");
        map2.put("e", "0");
        System.out.println("Before remove: " + map2);

        List<Map.Entry<String, String>> list = new ArrayList<>(map2.entrySet());
        list.sort(Map.Entry.comparingByValue());
        map2.values().removeAll(Collections.singleton("1"));
        map2.entrySet().removeIf(entry -> entry.getValue().equals("0"));
        System.out.println("After remove: " + map2);

    }

    public static void sortMapElements() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 3);
        map.put("b", 2);
        map.put("c", 1);

        LinkedHashMap<String, Integer> sortedmap = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedmap);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4);
        System.out.println(sortByValue1(map1));

        LinkedHashMap<String, Integer> collect = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Map<String, Integer> sortedMap = new TreeMap<>(map);

    }

    public static Map<String, Integer> sortByValue1(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}
