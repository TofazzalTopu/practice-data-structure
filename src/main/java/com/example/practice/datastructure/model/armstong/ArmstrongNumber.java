package com.example.practice.datastructure.model.armstong;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArmstrongNumber {

    //rule to find armstrong number
    //153 = 1*1*1 + 5*5*5 + 3*3*3
    public static void main(String[] args) {
        fiveDigitsArmstrongNumbers();
        calculateArmstrongNumber();
//        calculateArmstrongNumber(1534);
        calculateArmstrongNumberByConvertingList(92727);

    }

    public static void calculateArmstrongNumber() {
        int number = 153;
        int temp = number;
        int sum = 0;
        while (number > 0) {
            int remainder = number % 10;
            sum = sum + (remainder * remainder * remainder);
            number = number / 10;
        }
        if (temp == sum) {
            System.out.println(temp + " is Armstrong number");
        } else {
            System.out.println(temp + " is Not an armstrong number");
        }
    }

    public static void calculateArmstrongNumber(int number) {
        int temp = number;
        int sum = 0;

        //why 3 times because 153 = 1*1*1 + 5*5*5 + 3*3*3
        //so we need to multiply 3 times
        //if we have 4 digit number then we need to multiply 4 times
        //so we need to find the length of the number
        //int length = String.valueOf(number).length();
        //sum = sum + (remainder * remainder * remainder);
        //sum = sum + (remainder * remainder * remainder * remainder);
        //sum = sum + (remainder * remainder * remainder * remainder * remainder);
        //we can use Math.pow(remainder, length)
        //sum = sum + Math.pow(remainder, length);
        //why finding remainder and then multiplying because we need to find the cube of the number
        //so we need to find the remainder and then multiply it with itself length times
        //why remainder

        while (number > 0) {
            int remainder = number % 10;
            sum = sum + (remainder * remainder * remainder * remainder);
            number = number / 10;
        }
        if (temp == sum) {
            System.out.println(temp + " is Armstrong number");
        } else {
            System.out.println(temp + " is Not an armstrong number");
        }
    }

    public static void calculateArmstrongNumberByConvertingList(int number) {
        int temp = number;
        //1
        List<Integer> integers = Arrays.asList(String.valueOf(number).chars().mapToObj(c -> (char) c).map(Character::getNumericValue).toArray(Integer[]::new));
       //2
        List<Integer> integerList = Arrays.stream(String.valueOf(number).split("")).map(Integer::parseInt).toList();
        int sum = integerList.stream().map(i -> Math.pow(i, integerList.size())).mapToInt(Double::intValue).sum();
      //3
        int total = Arrays.stream(String.valueOf(number).split("")).map(i-> Math.pow(Integer.parseInt(i), integerList.size())).mapToInt(Double::intValue).sum();


        if (temp == sum) {
            System.out.println(temp + " is Armstrong number");
        } else {
            System.out.println(temp + " is Not an armstrong number");
        }
    }


    public static void fiveDigitsArmstrongNumbers() {
        System.out.println("5-Digit Armstrong Numbers are:");

        // Loop through all 5-digit numbers
        for (int num = 10000; num <= 99999; num++) {
            int originalNum = num;
            int sum = 0;

            // Extract digits and calculate the sum of their fifth powers
            while (originalNum != 0) {
                int digit = originalNum % 10; // Get the last digit
                sum += Math.pow(digit, 5);   // Add the fifth power of the digit
                originalNum /= 10;          // Remove the last digit
            }

            // Check if the sum equals the original number
            if (sum == num) {
                System.out.println(num);
            }
        }
    }


}
