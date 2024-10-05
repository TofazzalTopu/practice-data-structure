package com.example.practice.OnlineTest;

import java.util.*;

public class BrickSmashing {
    public static void main(String[] args) {
//        int n = 5;
        int[] newtons = {2};
//        int[] newtons = {3, 4, 1, 5};
//        int[] newtons = {7, 9, 3, 2, 5, 8, 4, 6};
//        int[] newtons = {3, 2, 5, 4, 6, 7, 9};
        int bigLimit = 0;

//        int[][] result = smashBricks(newtons.length, newtons, bigLimit);
        int[][] result = smashBricks(newtons.length, newtons, bigLimit);

        // Print the result
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] smashBricks(int n, int[] newtons, int bigHammerLimit) {
        List<Integer> bigHammerHits = new ArrayList<>();
        List<Integer> smallHammerHits = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        n = newtons.length;
        for (int i = 0; i < n; i++) {
            minHeap.offer(newtons[i]);
        }

        int totalHits = 0;
        while (!minHeap.isEmpty()) {
            int currNewton = minHeap.poll();
            totalHits++;

            if (bigHammerLimit > 0) {
                bigHammerHits.add(findBrickIndex(newtons, currNewton));
                bigHammerLimit--;
            } else {
                smallHammerHits.add(findBrickIndex(newtons, currNewton));
            }

            while (!minHeap.isEmpty() && minHeap.peek() == currNewton) {
                minHeap.poll();
                totalHits++;
                smallHammerHits.add(findBrickIndex(newtons, currNewton));
            }
        }
        Collections.sort(bigHammerHits);
        Collections.sort(smallHammerHits);
        return new int[][]{
                {totalHits},
                bigHammerHits.isEmpty() ? new int[]{-1} : bigHammerHits.stream().mapToInt(i -> i + 1).toArray(),
                smallHammerHits.isEmpty() ? new int[]{-1} : smallHammerHits.stream().mapToInt(i -> i + 1).toArray()
        };
    }

    private static int findBrickIndex(int[] newtons, int target) {
        for (int i = 0; i < newtons.length; i++) {
            if (newtons[i] == target) return i;
        }
        return -1;
    }


}


