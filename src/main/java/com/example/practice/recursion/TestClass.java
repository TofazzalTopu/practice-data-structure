package com.example.practice.recursion;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TestClass {
    public static long[] factArr = new long[10001];

    public static void main(String args[]) {
        findOddNumbers();
        BracketCombinations(3);

    }

    public static void findOddNumbers() {

//        int a = 1;
//        int b = 4;
//        int c = --a + b;
//        System.out.println(c);
//        String srt = "Hello";
//        System.out.println(srt.substring(1,4));
//        for (int i=0; i <srt.length() ; i++){
//            System.out.println(srt.charAt(i));
//        }

        List<String> list = new ArrayList<>(Arrays.asList("a", "b"));
//        String a = "s";
//        Integer i = 1;
//        int in = 1;
//        Scanner s = new Scanner(System.in);
//        int si = s.nextInt();
        int[] arr = new int[]{2, 3, 4, 6, 8, 9, 12};
        int result = IntStream.of(arr).filter(i -> i % 2 != 0).findFirst().getAsInt();
        System.out.println(result);

        double num = 1.34567;
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);

        System.out.println(df.format(num));
    }

    public static int BracketCombinations(int n) {
        long f1 = fact(2 * n);
        long f2 = fact(n + 1) * fact(n);
        long div = f1 / f2;
        System.out.println(div);
        return (int) (div);
//        return num;
    }

    public static long fact(int f) {
        if (f <= 1) return 1;
        if (factArr[f] == 0) {
            factArr[f] = f * fact(f - 1);
        }
        return factArr[f];
    }
}
