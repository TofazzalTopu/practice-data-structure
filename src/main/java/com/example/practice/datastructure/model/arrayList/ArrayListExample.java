package com.example.practice.datastructure.model.arrayList;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListExample {


    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("fg");
        list.add(45);
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 2, 1));
        a.add(6);
        a.forEach(System.out::println);
        System.out.println("UniqueElement: " + findUniqueElement(a));

        twoSum(new int[]{2, 5, 5, 11}, 10);
        twoSum(new int[]{3, 2, 4}, 6);
        twoSum(new int[]{3, 3}, 6);
//        twoSum(new int[]{2,8,7,11,15}, 9);
        findNubmerOfOccurence();
    }

    public static int findUniqueElement(List<Integer> a) {
//        a.forEach(e -> System.out.println(e));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            System.out.println(i);
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry e : map.entrySet()) {
            if (e.getValue().equals(1)) {
                return (int) e.getKey();
            }
        }
        return 0;
    }

    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order

        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target) && (i != j)) {
                    arr[0] = i;
                    arr[1] = j;
                    System.out.println(Arrays.toString(arr));
                    return arr;
                }
            }
        }
        return arr;
    }

    /*Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    Your solution must use only constant extra space.

    Example 1:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
    */

    public int[] twoSum2(int[] numbers, int target) {
        int[] arr = new int[2];
        boolean result = false;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if ((numbers[i] + numbers[j] == target) && (i != j)) {
                    arr[0] = i + 1;
                    arr[1] = j + 1;
                    result = true;
                    break;
                }
            }
            if (result) break;
        }

        return arr;
    }

    public static void findNubmerOfOccurence() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        Map<String, Long> counts =
                list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Set<String> st = new HashSet<>(list);
        for (String s : st) {
            System.out.println(s + ": " + Collections.frequency(list, s));
        }

    }
}
