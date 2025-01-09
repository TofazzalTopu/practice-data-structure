package com.example.practice.datastructure.model.map;

import java.util.HashMap;
import java.util.Map;

public class Example {

    public static void main(String[] args) {
        constructMapExample();
    }

    public static void constructMapExample(){
        // Create a new StringBuilder
        StringBuilder sb = new StringBuilder();
        // Append a string into StringBuilder
        sb.append("Hello");
        // Convert to string
        String str = sb.toString();

        Map<String, String > map = new HashMap<>();
        map.put(sb.toString(), "Hello");
        sb.append("World");

        map.put(sb.toString(), "World");
        sb.append("My");
        map.put(sb.toString(), "My");
        sb.append("Phone");
        map.put(sb.toString(), "Phone");
        System.out.println(map.size());
        map.entrySet().stream().forEach(e-> System.out.println(e.getKey() + " -- " + e.getValue()));
    }
}
