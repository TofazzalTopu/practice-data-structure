package com.example.practice.datastructure.model.string;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatedSubString {

    public static void main(String[] args) {
        getUniqueCharacterSubstring("CODINGISAWESOME");
        int len = longestUniqueSubStr("geeksforgeeks");
    }

    public static String getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar) + 1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        System.out.println(output.length());
        System.out.println(output);
        return output;
    }

    // This function returns true if all characters in
    // str[i..j] are distinct, otherwise returns false
    public static Boolean areDistinct(String str, int i, int j) {
        // Note : Default values in visited are false
        boolean[] visited = new boolean[256];
        for (int k = i; k <= j; k++) {
            if (visited[str.charAt(k)]) {
                return false;
            }
            visited[str.charAt(k)] = true;
        }
        return true;
    }

    // Returns length of the longest substring
    // with all distinct characters.
    public static int longestUniqueSubStr(String str) {
        int n = str.length();
        String st = "";
        // Result
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (areDistinct(str, i, j)) {
                    int lngth = j - i;
                    if (lngth > res) {
                        res = lngth;
                        st = str.substring(i, j+1);
                    }
                }
            }
        }
        System.out.println(st);
        System.out.println(st.length());
        return res;
    }

}
