package com.example.practice.OnlineTest;

import java.text.DecimalFormat;
import java.util.*;

public class CompaxCodingTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(m());
        MathChallenge();
    }
    public static String MathChallenge() {
//        double result = (2/3);
        double result = (123456789/10000);
//        System.out.format(Locale.GERMAN, "%.2f", result);
        DecimalFormat formatter = new DecimalFormat("#,###.0000");

        System.out.println(formatter.format(result));
        return formatter.format(result);
    }
    public static int m() {
        final String a = "a";
//        a = "f";
        String str = "(c(oder)) b(yte)";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String chr = String.valueOf(str.charAt(i));

            if (chr.equals("(")) {
                if (map.containsKey("(")) {
                    map.put("(", map.get(chr) + 1);
                } else {
                    map.put("(", 1);
                }
            }

            if (chr.equals(")")) {
                if (map.containsKey(chr)) {
                    map.put(")", map.get(chr) + 1);
                } else {
                    map.put(")", 1);
                }
            }
        }


        if(map.get("(").equals(map.get(")"))){
            return 1;
        } else {
            return 0;
        }

    }


}
