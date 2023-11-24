package com.example.practice.model.string;

import java.util.Scanner;

//Q #1) Write a Java Program to reverse a string without using String inbuilt function.
public class FinalReverseWithoutUsingStringMethods {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "Automation";
        char chars[] = str.toCharArray();
        //1
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();
        StringBuilder str4 = new StringBuilder();
        str2.append(str);
        str2 = str2.reverse();     // used string builder to reverse
        System.out.println(str2);
        System.out.println(str2.replace(0, 3, "we"));

        //2
        int n = str.length();
        for(int i =n-1; i >= 0; i--){
            str3.append(chars[i]);
        }
        System.out.println("str3 " + str3);

        for(int i =n-1; i >= 0; i--){
            str4.append(str.charAt(i));
        }
        System.out.println("str for loop: " + str4);

        //3
        for(int i =n-1; i >= 0; i--){
            System.out.print(chars[i]);
        }
        //4
        String str5;
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter your String: ");
        str5 = in.nextLine();
        String[] token = str5.split("");    //used split method to print in reverse order
        for(int i=token.length-1; i>=0; i--)
        {
            System.out.print(token[i] + "");
        }
        System.out.println("\n");
    }
}
