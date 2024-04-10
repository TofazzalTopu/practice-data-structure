package com.example.practice.model.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BracketMatcher {
    public static String bracketMatcher(String str) {
        // code goes here
        //if(str == null) return "1";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if (s.equals("(") || s.equals(")")) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        if (map.isEmpty() || (map.get("(").equals(map.get(")")))) {
            return "1";
        } else if (!map.get("(").equals(map.get(")"))) {
            return "0";
        }
        return "";
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(bracketMatcher(s.nextLine()));
    }
}
