package com.example.practice.OnlineTest;

import java.util.*;
import java.util.stream.Collectors;

public class JBConnect {

    public static void main(String[] args) {
        System.out.println(removeAllDigit("ft654dsd"));
        System.out.println();
        int num = 5;
        System.out.println("Factorial of " + num + " is " + factorial(5));
        System.out.println(binaryToDecimal("100101"));
    }

    static int factorial(int n) {
        int res = 1, i;
        for (i = 2; i <= n; i++)
            res *= i;
        return res;
    }

    static int binaryToDecimal(String n) {
        int num = Integer.parseInt(n);
        int dec_value = 0;

        // Initializing base
        // value to 1, i.e 2^0
        int base = 1;

        int temp = num;
        while (temp > 0) {
            int last_digit = temp % 10;
            temp = temp / 10;

            dec_value += last_digit * base;

            base = base * 2;
        }

        return dec_value;
    }

    public static String removeAllDigit(String str) {
        // Converting the given string
        // into a character array
        char[] charArray = str.toCharArray();
        String result = "";

        // Traverse the character array
        for (int i = 0; i < charArray.length; i++) {

            // Check if the specified character is not digit
            // then add this character into result variable
            if (!Character.isDigit(charArray[i])) {
                result = result + charArray[i];
            }
//            another approach
//            if (!Character.isDigit(str.charAt(i))) {
//                result = result + str.charAt(i);
//            }
        }

        // Return result
        return result;
    }

    public static void str() {


    }


}
