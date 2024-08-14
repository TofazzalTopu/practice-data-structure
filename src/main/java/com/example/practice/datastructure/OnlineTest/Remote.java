package com.example.practice.datastructure.OnlineTest;

import java.util.*;

public class Remote {

    public static void main(String[] args) {
        List<Integer> projectId = new ArrayList<>(Arrays.asList(0, 1, 0, 1, 1));
        List<Integer> bid = new ArrayList<>(Arrays.asList(4, 74, 47, 744, 7));

        System.out.println(minCost(2, projectId, bid));
    }

    public static long minCost(int numProjects, List<Integer> projectId, List<Integer> bid) {
        // Write your code here
        Set<Integer> uniquIntegers = new HashSet<>(projectId);
        long sum = 0;

//        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int s : uniquIntegers) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < projectId.size(); i++) {
                if (s == projectId.get(i)) {
                    arrayList.add(bid.get(i));
                }
            }
            Collections.sort(arrayList, Comparator.naturalOrder());
            sum += arrayList.get(0);
        }
//        sum = integerMap.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println(projectId);
        System.out.println(bid);
        return sum;
    }
}
