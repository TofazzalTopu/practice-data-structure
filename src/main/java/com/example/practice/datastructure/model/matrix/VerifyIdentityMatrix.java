package com.example.practice.datastructure.model.matrix;

import java.util.ArrayList;
import java.util.List;

public class VerifyIdentityMatrix {

    int MAX = 100;

    static boolean isIdentity(int mat[][], int N) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (row == col && mat[row][col] != 1)
                    return false;
                else if (row != col && mat[row][col] != 0)
                    return false;
            }
        }
        return true;
    }

    // Driver Code
    public static void main(String args[]) {
        int N = 4;
        int mat[][] = {{1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};

        if (isIdentity(mat, N))
            System.out.println("Yes ");
        else
            System.out.println("No ");

        generateIdentityMatrix(5);
    }

    static int generateIdentityMatrix(int num) {
        int row, col;
        List<List<Integer>> listList = new ArrayList<>();
        for (row = 0; row < num; row++) {
            List<Integer> list = new ArrayList<>();
            for (col = 0; col < num; col++) {
                // Checking if row is equal to column
                if (row == col) {
                    System.out.print(1 + " ");
                    list.add(1);
                } else {
                    list.add(0);
                    System.out.print(0 + " ");
                }
            }
            listList.add(list);
            System.out.println();
        }
        System.out.println(listList);
        return 0;
    }
}
