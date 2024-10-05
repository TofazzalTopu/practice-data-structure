package com.example.practice.datastructure.model.model.string;

import org.springframework.util.StringUtils;

public class StringUtilsExample {

    public String s = "jhvjh";
    public static void main(String[] args) {
        occurrence("fgrabcjufabch");
    }

    public static int occurrence(String str){
        int oc = StringUtils.countOccurrencesOf(str, "abc");
        System.out.println("occurrence: " + oc);
        boolean b = StringUtils.hasLength(str);
        System.out.println(b);

        return oc;
    }
}
