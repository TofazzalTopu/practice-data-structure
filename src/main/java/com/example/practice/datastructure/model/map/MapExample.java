package com.example.practice.datastructure.model.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args){
        final Map map = new HashMap();
        map.put(new Object(),9);
        map.put(6,"asd9");
        System.out.println(map.toString());

        Map<String, Integer> mp = new HashMap<>();
        mp.put("INDIA", 1);
        mp.put("BANGLADESH", 2);

        for(Map.Entry m : mp.entrySet()){
            System.out.println(m.getKey());
        }

        for (Map.Entry<String,Integer> entry : mp.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
