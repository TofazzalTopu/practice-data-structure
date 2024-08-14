package com.example.practice.datastructure.model.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringExample {

    //    Given a string s, find the length of the longest substring without repeating characters.
    public static void main(String[] args) {
        String str = "abcabcbb";
//        String str = "geeksforgeeks";
//        System.out.println("The input string is " + str);

//          First Answer
//        int len = longestUniqueSubsttr(str);
//        System.out.println("The length of the longest non-repeating character "
//                + "substring is " + len);

        //Second answer
//        assertEquals("ABCDEF", getUniqueCharacterSubstring("AABCDEF"));
        getUniqueCharacterSubstring("ADABCDEF");
        getUniqueCharacterSubstringBruteForce("abcabcbb");
    }

    static String getUniqueCharacterSubstringBruteForce(String input) {
        String output = "";
        for (int start = 0; start < input.length(); start++) {
            Set<Character> visited = new HashSet<>();
            int end = start;
            for (; end < input.length(); end++) {
                char currChar = input.charAt(end);
                if (visited.contains(currChar)) {
                    break;
                } else {
                    visited.add(currChar);
                }
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end);
            }
        }
        System.out.println(output);
        return output;
    }

    static String getUniqueCharacterSubstring(String s) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar) + 1, start);
            }
            if (output.length() < end - start + 1) {
                output = s.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        System.out.println(output);
        return output;
    }

    // This function returns true if all characters in str[i..j] are distinct, otherwise returns false
    public static Boolean areDistinct(String str, int i, int j) {
        // Note : Default values in visited are false
        boolean[] visited = new boolean[256];
        for (int k = i; k <= j; k++) {
            if (visited[str.charAt(k)] == true)
                return false;
            visited[str.charAt(k)] = true;
        }
        return true;
    }

    // Returns length of the longest substring with all distinct characters.
    public static int longestUniqueSubsttr(String str) {
        int n = str.length();
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (areDistinct(str, i, j))
                    res = Math.max(res, j - i + 1);
        return res;
    }

}
