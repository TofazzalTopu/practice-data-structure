package com.example.practice.datastructure.model.matrix;

public class DiagonalMatrix {

    /* Driver program to test above function */
    public static void main(String[] args) {
        int n = 3;

        int arr[][] =
                {
                        {11, 2, 4},
                        {4, 5, 6},
                        {10, 8, -12}
                };

        System.out.print(differenceOfTwoDiagonalOfAMatrix(arr, n));
    }

    public static int differenceOfTwoDiagonalOfAMatrix(int arr[][], int n) {
        int d1 = 0, d2 = 0;

        for (int i = 0; i < n; i++) {
            d1 += arr[i][i];
            d2 += arr[i][n - i - 1];
        }

        // Absolute difference of the sums across the diagonals
        return Math.abs(d1 - d2);
    }

    public static int differenceOfTwoDiagonalOfAMatrix2(int arr[][], int n) {
        // Initialize sums of diagonals
        int d1 = 0, d2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // finding sum of primary diagonal
                if (i == j)
                    d1 += arr[i][j];

                // finding sum of secondary diagonal
                if (i == n - j - 1)
                    d2 += arr[i][j];
            }
        }

        // Absolute difference of the sums across the diagonals
        return Math.abs(d1 - d2);
    }


}
