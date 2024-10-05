package com.example.practice.OnlineTest;

import java.util.*;

public class Brick {

    public static void main(String[] args) {
        int[] newtons = {3, 2, 5, 4, 6, 7, 9}; // Example newtons array
//        int[] newtons = {3, 5, 2, 4}; // Example newtons array
        int bigHammerLimit = 3; // Example big hammer limit
        List<Integer> list = Arrays.asList(7, 9, 3, 2, 5, 8, 4, 6);
//        smashTheBricks(9, list);
//        smashTheBricks( new int[]{3, 2, 5, 4, 6, 7, 9}, 4);
//        smashTheBricks(new int[]{3, 4, 1, 5},2);
//        smashTheBricks(new int[2],0);
//        smashBricks(new int[2],0);
//        smashBricks(1, new int[]{2},0);
        smashBricks(1, new int[]{3, 2, 5, 4, 6, 7, 9},0);

        int[][] result = smashBricks(newtons.length, newtons, 4);

        // Print the results
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] smashBricks(int n, int[] newtons, int bigHammerLimit) {
        PriorityQueue<Integer> bigHammerHits = new PriorityQueue<>();
        PriorityQueue<Integer> smallHammerHits = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (newtons[i] == 1) {
                bigHammerHits.offer(i + 1);
            } else {
                smallHammerHits.offer(newtons[i]);
            }
        }

        List<Integer> bigHits = new ArrayList<>();
        while (!bigHammerHits.isEmpty() && bigHammerLimit > 0) {
            int brickIndex = bigHammerHits.poll();
            bigHits.add(brickIndex);
            bigHammerLimit--;
        }

        List<Integer> smallHits = new ArrayList<>();
        while (!smallHammerHits.isEmpty()) {
            int bricks = smallHammerHits.poll();
            smallHits.add(bricks);
        }

        int totalHits = bigHits.size() + smallHits.size();
        int[] bigHitsArr = bigHits.isEmpty() ? new int[]{-1} : bigHits.stream().mapToInt(i -> i).toArray();
        int[] smallHitsArr = smallHits.isEmpty() ? new int[]{-1} : smallHits.stream().mapToInt(i -> i).toArray();

        return new int[][]{{totalHits}, bigHitsArr, smallHitsArr};
    }


}
//    This code calculates the total number of hits required to smash all the
//    bricks, then iterates through the bricks to determine which hammer
//    (big or small) to use for each brick and records the indices of
//    bricks smashed by each hammer.
//    Finally, it returns the results as a 2-dimensional array.
//
//
//
//        By sending a
