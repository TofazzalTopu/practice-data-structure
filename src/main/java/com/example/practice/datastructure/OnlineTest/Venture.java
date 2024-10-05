package com.example.practice.datastructure.OnlineTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Venture {

    public static void main(String[] args) {
        System.out.println(LetterChanges("hello*3"));
        System.out.println(StarRating("0.38"));
        System.out.println(replaceAllDigits("hgcfhjg65e65g"));
        System.out.print(replaceVowels("hgcfhjg65e65g"));
    }

    public static String StarRating(String str) {
        // code goes here

        String result = "";
        double num = Double.parseDouble(str);

        int intPart = (int) num;
        double decimalPart = num - intPart;

        int j = 0;
        for (int i = 1; i <= intPart; i++) {
            result += "full ";
            j++;
        }

        if (decimalPart > 0) {
            result += "half ";
            j++;
        }

        while (j < 5) {
            result += "empty ";
            j++;
        }

        return result;
    }

    public static String LetterChanges(String str) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            int idx = list.indexOf(String.valueOf(str.charAt(i)));
            if (idx == 25) {
                result.append(list.get(0));
            } else if (idx == -1) {
                result.append(str.charAt(i));
            } else {
                result.append(list.get(idx + 1));
            }
        }
        List<String> vowels = List.of("a","e","i","o","u");
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            String chr = String.valueOf(result.charAt(i));
            if (vowels.contains(chr)) {
                chr = chr.toUpperCase();
            }
            rs.append(chr);
        }

        return rs.toString();
    }

    public static String replaceAllDigits(String str) {
//        return str.replaceAll("[0-9]","");
        return str.replaceAll("\\d","");
    }

    public static String replaceVowels(String args) {
        String s = "prepinsta";
        String s1 = "";
        s1 = s.replaceAll("[aeiou]", "");
//        System.out.println("String after removing vowel : "+s1);
        return s1;
    }

    public static void re(String str){

    }
}
