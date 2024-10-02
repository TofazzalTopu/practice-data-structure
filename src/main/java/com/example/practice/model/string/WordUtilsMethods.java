package com.example.practice.model.string;

import org.apache.commons.text.WordUtils;

public class WordUtilsMethods {

    public static void main(String[] args) {
        firstLetterUpperCase("This is my world");
    }


    public static String firstLetterUpperCase(String str) {
        StringBuilder sb = new StringBuilder(str);
        String a = WordUtils.swapCase(str);
        String b = WordUtils.capitalize(str);
        String c = WordUtils.initials(str);
        String d = WordUtils.capitalizeFully(str);

        System.out.println(a + " | " + b + " | " + c  + " | " + d);

        System.out.println(str.replace("t", "T"));
        System.out.println(sb.insert(4, 1));
        System.out.println(sb.replace(4, 8, "HI")); //replace start to end with specified string
        return sb.toString();
    }
}
