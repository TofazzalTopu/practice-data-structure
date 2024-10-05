package com.example.practice.model.string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ReverseVowels {
    public static void main(String[] args) throws IOException {
//        System.out.println("result: "+ reverseVowels("IceCreAm"));
    }

    public static String getStr(String str){
        List<String> stringList = new ArrayList<>(Arrays.asList("212"));
        List<Integer> integerList = new ArrayList<>();
        Map<String,String> map = new HashMap<>();


        return "";
    }

    public static String reverseVowels(String s) {
        List<String> list = new ArrayList<>();
        String[] arr = s.split("");
        for (int i = 0; i < s.length(); i++) {
            String sr = String.valueOf(arr[i]);
            if (sr.equalsIgnoreCase("a") || sr.equalsIgnoreCase("e") || sr.equalsIgnoreCase("i") || sr.equalsIgnoreCase("o") || sr.equalsIgnoreCase("u")) {
                list.add(sr);
            }
        }
        int j = list.size() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String sr = String.valueOf(arr[i]);
            if (sr.equalsIgnoreCase("a") || sr.equalsIgnoreCase("e") || sr.equalsIgnoreCase("i") || sr.equalsIgnoreCase("o") || sr.equalsIgnoreCase("u")) {
                sb.append(list.get(j));
                j--;
            } else {
                sb.append(sr);
            }
        }
        return sb.toString();
    }
}
