package com.example.practice.model.string;

import java.util.*;

public class SwapTwoNumbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        swapUsingThirdVariable();
//        swapWithoutUsingThirdVariable();
//        countNumberOfWords();
//        iterateMapUsingWhileLoop();
        checkPrimeNumber();
//        checkPalindrome();
//        checkFibonacci();
//        findSecondHighestNumberOfAnArray();
//        ArmstrongNumber();
//        replaceWhiteSpace();
//        StringJoinerExample();
//        say();

    }

    //Q #3) Write a Java Program to swap two numbers using the third variable.
    public static void swapUsingThirdVariable() {
        int x, y, temp;
        System.out.println("Enter x and y");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        System.out.println("Before Swapping " + x + "  " + y);
        temp = x;
        x = y;
        y = temp;
        System.out.println("After Swapping " + x + "  " + y);
    }

    //    Q #4) Write a Java Program to swap two numbers without using the third variable.
    public static void swapWithoutUsingThirdVariable() {
        int x, y;
        System.out.println("Enter x and y");
        Scanner in = new Scanner(System.in);

        x = in.nextInt();
        y = in.nextInt();

        System.out.println("Before Swapping\nx = " + x + "\ny = " + y);

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("After Swapping without third variable\nx = " + x + " y= " + y);
    }


    //Q #5) Write a Java Program to count the number of words in a string using HashMap.
    public static void countNumberOfWords() {
        String str = "This this is is done by Saket Saket";
        String[] split = str.split(" ");

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < split.length; i++) {
            if (map.containsKey(split[i])) {
                int count = map.get(split[i]);
                map.put(split[i], count + 1);
            } else {
                map.put(split[i], 1);
            }
        }
        System.out.println(map);
    }

    //Q #6) Write a Java Program to iterate HashMap using While and advance for loop.
    public static void iterateMapUsingWhileLoop() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "Saket");
        map.put(25, "Saurav");
        map.put(12, "HashMap");
        System.out.println(map.size());
        System.out.println("While Loop:");
        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry me = (Map.Entry) itr.next();
            System.out.println("Key is " + me.getKey() + " Value is " + me.getValue());
        }
        System.out.println("For Loop:");
        for (Map.Entry me2 : map.entrySet()) {
            System.out.println("Key is: " + me2.getKey() + " Value is: " + me2.getValue());
        }
        System.out.println(map);
    }

    //Q #7) Write a Java Program to find whether a number is prime or not.
    public static void checkPrimeNumber() {
        int temp, num;
        boolean isPrime = true;
//        Scanner in = new Scanner(System.in);
//        num = in.nextInt();
//        in.close();
//        boolean isPrime = true;
//
//        int m = num / 2;
//        if (num == 0 || num == 1) {
//            isPrime = false;
//        } else {
//            for (int i = 2; i <= m; i++) {
//                if (num % i == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//        }
//
//        if (isPrime)
//            System.out.println(num + " number is prime");
//        else {
//            System.out.println(num + " number is not a prime");
//        }
    }

    //Q #8) Write a Java Program to find whether a string or number is palindrome or not.
    public static void checkPalindrome() {
        String original, reverse = "";
        Scanner in = new Scanner(System.in);
        int length;
        System.out.println("Enter the number or String");
        original = in.nextLine();
        length = original.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }
        System.out.println("reverse is:" + reverse);

        if (original.equals(reverse))
            System.out.println("The number is palindrome");
        else
            System.out.println("The number is not a palindrome");
    }

    //Q #9) Write a Java Program for the Fibonacci series.
    public static void checkFibonacci() {
        int num, a = 0, b = 0, c = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of times");
        num = in.nextInt();
        System.out.println("Fibonacci Series of the number is:");
        for (int i = 0; i < num; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a + " ");    //if you want to print on the same line, use print()
        }
        System.out.print(" \n");
    }

    //Q #16) Write a Java Program to find the second-highest number in an array.

    public static void findSecondHighestNumberOfAnArray() {
        int arr[] = {100, 14, 46, 47, 94, 94, 52, 86, 36, 94, 89};
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("\nSecond largest number is:" + secondLargest);
        System.out.println("Largest Number is: " + largest);
    }

    //Q #17) Write a Java Program to check Armstrong number.
    public static void ArmstrongNumber() {
        int c = 0, a, temp;
        int n = 153;//It is the number to check Armstrong
        temp = n;

        //1
        String num = String.valueOf(n);
        int sum=0;
        for(int i = 0; i < num.length(); i++){
            sum += (Integer.parseInt(String.valueOf(num.charAt(i))) * Integer.parseInt(String.valueOf(num.charAt(i))) * Integer.parseInt(String.valueOf(num.charAt(i))));
        }

        //2
        while (n > 0) {
            a = n % 10;
            n = n / 10;
            c = c + (a * a * a);
        }
        if (temp == c)
            System.out.println("armstrong number");
        else
            System.out.println("Not armstrong number");
    }

    //Q #18) Write a Java Program to remove all white spaces from a string with using replace().
    public static void replaceWhiteSpace() {
        String str1 = "Saket Saurav        is a QualityAna    list";
        //1. Using replaceAll() Method
        String str2 = str1.replaceAll("\\s", "");
        System.out.println(str2);
    }
    public static void StringJoinerExample() {
        StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter
        // Adding values to StringJoiner
        joinNames.add("Rahul");
        joinNames.add("Raju");
        joinNames.add("Peter");
        joinNames.add("Raheem");
        System.out.println(joinNames);

        StringJoiner joiner = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter

        // Adding values to StringJoiner
        joiner.add("Sohel");
        joiner.add("Raju");
        joiner.add("Peter");
        joiner.add("Rana");

        System.out.println(joiner);

        // Merging two StringJoiner
        StringJoiner merge = joinNames.merge(joiner);
        System.out.println(merge);

        // Prints nothing because it is empty
        System.out.println(joinNames);

        // Returns length of StringJoiner
        int length = joinNames.length();
        System.out.println("Length: "+length);

        // Returns StringJoiner as String type
        String str = joinNames.toString();
        System.out.println(str);

        // Now, we can apply String methods on it
        char ch = str.charAt(3);
        System.out.println("Character at index 3: "+ch);

        // Adding one more element
        joinNames.add("Sorabh");
        System.out.println(joinNames);

        // Returns length
        int newLength = joinNames.length();
        System.out.println("New Length: "+newLength);

        List<String> valuesList = Arrays. asList("value1", "value2", "value3");
        String commaSeparatedValues = String.join("; ", valuesList);
        System. out. println(commaSeparatedValues);
    }


    void a(){
        int c = 0, a, temp;
        int n = 153;
        temp = n;
        while(n>3){
            a= n%10;
            n = n/10;
            c = c + (a*a*a);
        }

        if(temp == c) System.out.println("Armstrong number");
    }

    void b(){
        int a, b =0, c=1;
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num; i++){
            a = b;
            b = c;
            c = a +b;
            System.out.print(c + " ");
        }
    }
    //Java Lambda Expression Example: No Parameter
    static void say(){
        Sayable s=()->{ return "hi";};
        System.out.println(s.say());

        // Multiple parameters in lambda expression
        Addable ad1=(a,b)->(a+b);
        System.out.println(ad1.add(10,20));

        // Multiple parameters with data type in lambda expression
        Addable ad2=(int a,int b)->(a+b);
        System.out.println(ad2.add(100,200));


    }
    
}
interface Addable{
    int add(int a,int b);
}
interface Sayable{
    public String say();
}

