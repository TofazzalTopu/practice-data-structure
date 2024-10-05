package com.example.practice.OnlineTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//acc
public class Test1 {


    public static void main(String[] args) {
        minimumNumberOfSeniorDev();
    }

    public static int minimumNumberOfSeniorDev() {
        List<Integer> a = Arrays.asList(1, 2);
        List<Integer> b = Arrays.asList(1, 3);
        List<List<Integer>> teams = new ArrayList<>(Arrays.asList(a, b));

        double totalP = 0;
        double total = 0;
        double totalSen = 0;
        double totalDev = 0;
        int i = 0;
        for (List<Integer> team : teams) {
            System.out.println(team);
            if (team.size() > 0) {
                totalSen += team.get(0);
                totalDev += team.get(1);
                totalP = (totalSen / totalDev) * 100;
            }
        }

        while (totalP < 50) {
            i += 1;
            totalSen += 1;
            totalDev += 1;
            totalP = (totalSen / totalDev) * 100;
        }

        System.out.println(totalSen + "  " + totalDev);
        System.out.println(i);
        return i;
    }

}
