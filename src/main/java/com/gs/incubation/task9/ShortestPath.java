package com.gs.incubation.task9;

import java.util.*;

public class ShortestPath {

    private static List<Integer> findShortestPath(List<List<Integer>> trainMap, int source, int destination) {
        if (trainMap == null || trainMap.isEmpty()) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        List<Integer> path = new ArrayList<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();
        Map<Integer, Integer> cost = new HashMap<>();
        Map<Integer, Integer> predecessor = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        isVisited.put(source, true);
        cost.put(source, 1);
        predecessor.put(source, -1);
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            for (Integer adjacent : trainMap.get(temp)) {
                if (!isVisited.containsKey(adjacent)) {
                    queue.add(adjacent);
                    isVisited.put(adjacent, true);
                    cost.put(adjacent, cost.get(temp) + 1);
                    predecessor.put(adjacent, temp);
                }
                if (adjacent == destination) {
                    queue.clear();
                    break;
                }
            }
        }

        int current = destination;
        while (current != -1) {
            path.add(current);
            current = predecessor.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1));
        graph.add(Arrays.asList(0, 2, 4));
        graph.add(Arrays.asList(1, 3));
        graph.add(Arrays.asList(2, 4));
        graph.add(Arrays.asList(3, 1));
        System.out.println(ShortestPath.findShortestPath(graph, 0, 4));
    }


}
