package com.example.practice.datastructure.model.model.string;

public class GreatestDivisorOfString {

    public static void main(String[] args) {
//        System.out.println("Result: " + gcdOfStrings("ABCABC", "ABC"));
        System.out.println("Result: " + gcdOfStrings("ABABAB", "ABAB"));
    }
    public static String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(0, gcd(n1, n2));
    }

    private static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }
    public static String gcdOfStringss(String str1, String str2) {
        String result = "";

        if (str1.length() > 1 && str1.length() <= 100 && str2.length() >= 1 && str2.length() <= 100) {
            String str = str1.length() > str2.length() ? str1 : str2;
            int n = str.length();
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    String s = str.substring(i, j);
                    if (!s.equals("") && str1.contains(s) && str2.contains(s)) {
                        if (result.length() < s.length()) result = s;
                        if (s.length() > 2 && s.length() % 2 == 0) {
                            int l = s.length()/2;
                            if (s.substring(0, l).equals(s.substring(l)))
                                result = s.substring(l);
                        }
                    }
                }
            }
        }
        return result;
    }
}
