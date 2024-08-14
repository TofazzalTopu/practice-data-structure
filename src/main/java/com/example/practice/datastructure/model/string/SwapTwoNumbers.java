package com.example.practice.datastructure.model.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SwapTwoNumbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        swapUsingThirdVariable();
//        swapWithoutUsingThirdVariable();
        countNumberOfWords();
        iterateMapUsingWhileLoop();
        checkPrimeNumber();
        checkPalindrome();
        checkFibonacci();
        findSecondHighestNumberOfAnArray();
        ArmstrongNumber();
        replaceWhiteSpace();
        StringJoinerExample();
        sortInDescendingOrderArrayAlgorithm(new int[]{3, 4, 2, 7, 9, 4});
        sortInAscendingOrderArrayAlgorithm(new int[]{3, 4, 2, 7, 9, 4});
        reduceMethod(new int[]{3, 4, 2, 7, 9, 4});
        say();

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
        String str = "This this is done by Saket Saket";
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
        int temp, num = 19;
        boolean isPrime = true;

        // 1
        int m = num / 2;
        if (num == 0 || num == 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= m; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime)
            System.out.println(num + " number is prime");
        else {
            System.out.println(num + " number is not a prime");
        }

        // 2
        OptionalInt findAny = IntStream.range(2, m + 1).filter(i -> num % i == 0).findAny();
        List<Integer> findList = IntStream.range(2, m + 1).boxed().collect(Collectors.toList()).stream().filter(i -> num % i == 0).collect(Collectors.toList());
        if (findList.isEmpty()) System.out.println("Prime");
        else System.out.println("Not Prime");
    }

    //Q #8) Write a Java Program to find whether a string or number is palindrome or not.
    public static void checkPalindrome() {
        String original = "adcfd", reverse = "";
        int length;
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
        int num = 10, a = 0, b = 0, c = 1;
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
    // An Armstrong number is a positive m-digit number that is equal to the sum of the mth powers of their digits.
    public static void ArmstrongNumber() {
        int c = 0, a, temp, digits = 0;
        int n = 153;//It is the number to check Armstrong
        temp = n;

        //1
        String num = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += (int) Math.pow(Integer.parseInt(String.valueOf(num.charAt(i))), num.length());
        }

        //2
        int length = String.valueOf(n).length();
        while (temp > 0) {
            temp = temp / 10;
            digits++;
        }
        while (n > 0) {
            a = n % 10;
            n = n / 10;
            c += (int) (Math.pow(a, length));
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
        System.out.println("Length: " + length);

        // Returns StringJoiner as String type
        String str = joinNames.toString();
        System.out.println(str);

        // Now, we can apply String methods on it
        char ch = str.charAt(3);
        System.out.println("Character at index 3: " + ch);

        // Adding one more element
        joinNames.add("Sorabh");
        System.out.println(joinNames);

        // Returns length
        int newLength = joinNames.length();
        System.out.println("New Length: " + newLength);

        List<String> valuesList = Arrays.asList("value1", "value2", "value3");
        String commaSeparatedValues = String.join("; ", valuesList);
        System.out.println(commaSeparatedValues);
    }


    void a() {
        int c = 0, a, temp;
        int n = 153;
        temp = n;
        while (n > 3) {
            a = n % 10;
            n = n / 10;
            c = c + (a * a * a);
        }

        if (temp == c) System.out.println("Armstrong number");
    }

    void b() {
        int a, b = 0, c = 1;
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.print(c + " ");
        }
    }

    //Java Lambda Expression Example: No Parameter
    static void say() {
        Sayable s = () -> {
            return "hi";
        };
        System.out.println(s.say());

        // Multiple parameters in lambda expression
        Addable ad1 = (a, b) -> (a + b);
        System.out.println(ad1.add(10, 20));

        // Multiple parameters with data type in lambda expression
        Addable ad2 = (int a, int b) -> (a + b);
        System.out.println(ad2.add(100, 200));


    }

    public static int[] sortInDescendingOrderArrayAlgorithm(int[] array) { //sort in descending order
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] >= array[j]) {
                    int x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static int[] sortInAscendingOrderArrayAlgorithm(int[] array) { //sort in ascending order
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int x = array[j];
                    array[j] = array[i];
                    array[i] = x;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static int reduceMethod(int[] array) {
        int sum = Arrays.stream(array).reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int result = Arrays.stream(array).reduce(0, Integer::sum);
        assert result == 29;

        List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
        int computedAges = ages.parallelStream().reduce(0, (a, b) -> a + b, Integer::sum);
//        When a stream executes in parallel, the Java runtime splits the stream into multiple substreams.
//        In such cases, we need to use a function to combine the results of the substreams into a single one.
//        This is the role of the combiner — in the above snippet, it’s the Integer::sum method reference.

        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
        // The result of the reduce() method is an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> longestString = words.stream().reduce((word1, word2)
                -> word1.length() > word2.length() ? word1 : word2);
        // Displaying the longest String
        longestString.ifPresent(System.out::println);

//        For instance, we can use reduce() on an array of String elements and join them into a single result:
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String resu = letters.stream().reduce("", (partialString, element) -> partialString + element);
//        assertThat(result).isEqualTo("abcde");
//        Similarly, we can switch to the version that uses a method reference:

        String resul = letters.stream().reduce("", String::concat);
//        Let’s use the reduce () operation for joining the uppercase elements of the letters array:

        String res = letters.stream().reduce(
                        "", (partialString, element) -> partialString.toUpperCase() + element.toUpperCase());
//        assertThat(result).isEqualTo("ABCDE");
//        In addition, we can use reduce() in a parallelized stream (more on this later):

        return sum;
    }

}

interface Addable {
    int add(int a, int b);
}

interface Sayable {
    public String say();
}

