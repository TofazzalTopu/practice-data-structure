package com.example.practice.datastructure.model.array.subsequence;

import java.util.*;

public class FindAllSubsequences {

    static Map<Long, List<Integer>> map = new HashMap<>();

    public static void printAllSubSequences(int[] arrInput) {
        int[] temp = new int[arrInput.length];
        int index = 0;
        solve(arrInput, index, temp);
    }

    private static void solve(int[] arrInput, int index, int[] temp) {
        if (index == arrInput.length) {
            print(arrInput, temp);
            return;
        }
        //set the current index bit and solve it recursively
        temp[index] = 1;
        solve(arrInput, index + 1, temp);
        //unset the current index bit and solve it recursively
        temp[index] = 0;
        solve(arrInput, index + 1, temp);
    }

    private static void print(int[] arrInput, int[] temp) {
        List<Integer> list = new ArrayList<>();
        String result = "";
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 1) {
                result += arrInput[i] + " ";
                list.add(arrInput[i]);
            }
        }
        long sum = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            sum += list.get(i) - list.get(i-1);
        }
        if(map.containsKey(sum)){
            if(map.get(sum).size() < list.size()){
                map.put(sum, list);
            }
        } else {
            map.put(sum, list);
        }
        if (result == "") {
            result = "{Empty Set}";
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] arrInput = {5, 87, 99, 85, 50, 93};
        Arrays.sort(arrInput);
        printAllSubSequences(arrInput);
        System.out.println(map);
    }
}
