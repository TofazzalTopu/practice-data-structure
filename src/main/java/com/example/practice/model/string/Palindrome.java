package com.example.practice.model.string;

//Q #8) Write a Java Program to find whether a string or number is palindrome or not.

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        checkIfPalindrome("aka");
        System.out.print("\nLength is: " + longestPalSubstr("forgeeksskeegfor"));

    }

    public static void checkIfPalindrome(String original) {
        String reverse = "";
        int length = original.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }
        System.out.println("reverse is:" + reverse);

        if (original.equals(reverse))
            System.out.println("The number is palindrome");
        else
            System.out.println("The number is not a palindrome");
    }

    // Function to print a subString str[low..high]
    static void printSubStr(String str, int low, int high) {
        for (int i = low; i <= high; ++i)
            System.out.print(str.charAt(i));
    }

    // This function prints the longest palindrome subString
    // It also returns the length of the longest palindrome
    static int longestPalSubstr(String str) {
        // Get length of input String
        int n = str.length();

        // All subStrings of length 1
        // are palindromes
        int maxLength = 1, start = 0;

        // Nested loop to mark start and end index
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k)
                            != str.charAt(j - k))
                        flag = 0;

                // Palindrome
                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);
        // Return length of LPS
        return maxLength;
    }

}
