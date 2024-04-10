package com.example.practice.model.string;

public class PairsOfAmicableNumbers {

    // Driver code
    public static void main(String args[]) {
        int arr1[] = { 220, 284, 1184, 1210, 2, 5 };
        int n1 = arr1.length;
        System.out.println(countPairs(arr1, n1));
        int arr2[] = { 2620, 2924, 5020, 5564, 6232, 6368 };
        int n2 = arr2.length;
        System.out.println(countPairs(arr2, n2));
    }

    // This function prints pair
    //  of amicable pairs present
    // in the input array
    static int countPairs(int arr[], int n) {
        int count = 0;
        // Iterate through each pair,
        // and find if it an amicable pair
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (isAmicable(arr[i], arr[j]))
                    count++;
        return count;
    }

    // Check if pair is amicable
    static boolean isAmicable(int a, int b) {
        return (sumOfDiv(a) == b &&
                sumOfDiv(b) == a);
    }
    // Calculate the sum
    // of proper divisors
    static int sumOfDiv(int x) {
        // 1 is a proper divisor
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                sum += i;
                System.out.println("Devisor: " + i);
                // To handle perfect squares
                if (x / i != i)
                    sum += x / i;
            }
        }

        return sum;
    }
}
