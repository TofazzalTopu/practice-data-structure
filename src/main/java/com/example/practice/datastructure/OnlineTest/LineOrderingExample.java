package com.example.practice.datastructure.OnlineTest;

import java.util.*;

public class LineOrderingExample {

    public static String LineOrdering(String[] strArr) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        Set<Character> allNodes = new HashSet<>();

        // Parse constraints into graph
        for (String s : strArr) {
            char from, to;
            if (s.charAt(1) == '>') {
                from = s.charAt(0);
                to = s.charAt(2);
            } else { // '<'
                from = s.charAt(2);
                to = s.charAt(0);
            }

            graph.computeIfAbsent(from, k -> new HashSet<>()).add(to);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
            inDegree.putIfAbsent(from, 0);

            allNodes.add(from);
            allNodes.add(to);
        }

        // Backtracking for all topological orderings
        int[] count = new int[1];
        allTopologicalSorts(graph, inDegree, new ArrayList<>(), allNodes.size(), count);
        return String.valueOf(count[0]);
    }

    private static void allTopologicalSorts(Map<Character, Set<Character>> graph, Map<Character, Integer> inDegree,
                                            List<Character> currentOrder, int totalNodes, int[] count) {
        boolean flag = false;

        for (char node : inDegree.keySet()) {
            if (inDegree.get(node) == 0 && !currentOrder.contains(node)) {
                // Choose this node
                currentOrder.add(node);

                if (graph.containsKey(node)) {
                    for (char neighbor : graph.get(node)) {
                        inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    }
                }

                allTopologicalSorts(graph, inDegree, currentOrder, totalNodes, count);

                // Backtrack
                currentOrder.remove(currentOrder.size() - 1);
                if (graph.containsKey(node)) {
                    for (char neighbor : graph.get(node)) {
                        inDegree.put(neighbor, inDegree.get(neighbor) + 1);
                    }
                }

                flag = true;
            }
        }

        // If currentOrder contains all nodes, it's a valid ordering
        if (!flag && currentOrder.size() == totalNodes) {
            count[0]++;
        }
    }

    // Test it
    public static void main(String[] args) {
//        System.out.println(LineOrdering(new String[]{"J>B", "B<S", "D>J"})); // Output: 3
//        System.out.println(LineOrdering(new String[]{"A>B", "B>C", "C>A"})); // Output: 0 (cycle)
//        System.out.println(LineOrdering(new String[]{"A>B", "A<C", "C<Z"})); // Output: 0 (cycle)
//        System.out.println(LineOrdering(new String[]{"A>B", "B<R", "R<G"})); // Output: 3 (cycle)
        System.out.println(LineOrdering(new String[] {"A>B","A<C","C<Z"})); // Output: 1 (cycle)
    }
}
