package com.example.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String votes[] = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
        String vote[] = {"virat", "rohit", "rishabh", "rohit", "virat", "rohit"};
        String str = findNames(votes);
        assert str.equals("Output: johnny john") : "Error.....Test Failed";
        List<String> stringList = Arrays.asList("john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john");
        findNames(stringList);
        String s = findNames(vote);
        assert s.equals("Output: rohit") : "Error.....";
        assert s.equals("Output: rohit") : "Error.....";
    }

    //Array
    public static String findNames(String votes[]) {

        Map<String, Long> maps = Arrays.stream(votes).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            if (!map.containsKey(votes[i])) {
                map.put(votes[i], 1);
            } else {
                map.put(votes[i], map.get(votes[i]) + 1);
            }
        }

        List<Integer> numbers = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        int max = Collections.max(numbers);

        StringBuilder sb = new StringBuilder("Output: ");
        map.entrySet().stream().forEach(e -> {
            if (e.getValue() == max) sb.append(e.getKey()).append(" ");
        });
        System.out.println(sb.toString().stripTrailing());
        return sb.toString().stripTrailing();
    }

    //ArrayList
    public static String findNames(List<String> votes) {
        Map<String, Integer> map = new TreeMap<>();
        new HashSet<>(votes).forEach(s-> map.put(s, Collections.frequency(votes, s)));

        List<String> keys = new ArrayList<>(map.keySet());
        List<Integer> values = new ArrayList<>(map.values());
        List<Integer> numbers = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        int max = Collections.max(map.values());
        StringBuilder sb = new StringBuilder("Output: ");
        map.entrySet().forEach(e -> {
            if (e.getValue() == max) sb.append(e.getKey()).append(" ");
//            if (e.getValue() == max) System.out.print(e.getKey() +" ");
        });

        String join = String.join(" and ", map.keySet());
        String joine = String.join(" and ", map.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        String joined = map.keySet().stream().collect(Collectors.joining(" and "));
        System.out.println(joined);
        return sb.toString().stripTrailing();
    }

    public void test() {
        String votes[] = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
        String str = findNames(votes);
        int value = 23;
        assert value >= 18 : " Not valid";
        assert str.equals("johnny john ") : "jhbv";
//        Assert.hasText();
    }

}
