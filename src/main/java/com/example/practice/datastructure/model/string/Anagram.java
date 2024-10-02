package com.example.practice.datastructure.model.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

//Two strings are said to be anagram if we can form one string by arranging the characters of another string.
// For example, Race and Care.
    public static void main(String[] args) {
        System.out.println(isAnagram("a", "ab"));
        System.out.println(isAnagram("abcdef", "efbacd"));
        System.out.println(isAnagram("geeksforgeeks", "forgeeksgeeks"));
    }

    public static boolean isAnagram(String s1, String s2){
//        List<String> list = new ArrayList<>(Arrays.asList("a","b", "c"));
//        List<String> list1 = new ArrayList<>(Arrays.asList("a","b", "c"));
//        List<String> list = new ArrayList<>(Arrays.asList(s1.split("")));
//        List<String> list1 = new ArrayList<>(Arrays.asList(s2.split("")));
//        Collections.sort(list);
//        Collections.sort(list1);
//        System.out.println(list1.equals(list));
        if(s1.length() != s2.length()) return false;
        Map<String, Long> map = Arrays.stream(s1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> map2 = Arrays.stream(s2.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String arr[] = s1.split("");
        for (int i = 0; i < s1.length(); i++) {
            if (!map.get(arr[i]).equals(map2.get(arr[i]))) {
                return false;
            }
        }
        return true;
    }
}
