package com.example.practice;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class Test {

    public static void main(String[] args) {

    ArrayList<String> strings = new ArrayList<>();
    String[] a = {"d"};
    strings.addAll(Arrays.asList(a));
    strings.get(0).set
    log.debug("err");
    log.trace("deb");
    log.info("tr");
    log.error("info");
    f(2.3f);
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

        Map<String, Long> map = Arrays.stream(votes).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Long> numbers = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        Long maxNumber = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()).stream().max(Comparator.naturalOrder()).get();
        Set<Map.Entry<String, Long>> collect = map.entrySet().stream().filter(e -> Objects.equals(e.getValue(), maxNumber)).collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder("Output: ");

        collect.forEach(e -> {
            sb.append(e.getKey()).append(" ");
        });
        System.out.println(sb.toString().stripTrailing());
        return sb.toString().stripTrailing();
    }

    //ArrayList
    public static String findNames(List<String> votes) {
        Map<String, Integer> map = new TreeMap<>();
        new HashSet<>(votes).forEach(s -> map.put(s, Collections.frequency(votes, s)));
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < votes.length; i++) {
//            if (!map.containsKey(votes[i])) {
//                map.put(votes[i], 1);
//            } else {
//                map.put(votes[i], map.get(votes[i]) + 1);
//            }
//        }

        List<String> keys = new ArrayList<>(map.keySet());
        List<Integer> values = new ArrayList<>(map.values());
        List<Integer> numbers = map.entrySet().stream().map(Map.Entry::getValue).sorted().collect(Collectors.toList());
        int max = Collections.max(map.values());
        StringBuilder sb = new StringBuilder("Output: ");
        map.forEach((key, value) -> {
            if (value == max) sb.append(key).append(" ");
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

    private double whtsi;

    private static Double mm(ExecutorService executorService, Callable<Double> task) {
            try{
                return executorService.submit(task).get();
            } catch (Exception e){
                return null;
            }
    }

    public static void f(float f){
        System.out.println(f);
    }


}
