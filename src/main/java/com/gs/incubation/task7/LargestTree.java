package com.gs.incubation.task7;

import java.util.HashMap;
import java.util.Map;

public class LargestTree {

    public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        if (immediateParent == null || immediateParent.isEmpty())
            throw new IllegalArgumentException("Invalid i/p");
        Map<Integer, Integer> nodeCounter = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            int currentParent = entry.getValue();
            while (immediateParent.containsKey(currentParent)) {
                currentParent = immediateParent.get(currentParent);
            }

            if (!nodeCounter.containsKey(currentParent)) {
                nodeCounter.put(currentParent, 2);
            } else {
                nodeCounter.put(currentParent, nodeCounter.get(currentParent) + 1);
            }
        }
        int max = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : nodeCounter.entrySet()) {
            if (entry.getValue() >= max) {
                max = entry.getValue();
                if (res > entry.getKey())
                    res = entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> m1 = new HashMap<>();
        m1.put(1, 2);
        m1.put(5, 7);
        m1.put(2, 5);

        Map<Integer, Integer> m2 = new HashMap<>();
        m2.put(1, 2);
        m2.put(3, 4);
        m2.put(2, 6);
        m2.put(4, 5);
        m2.put(0, 2);
        m2.put(7, 6);

        System.out.println(LargestTree.largestTree(m1));
        System.out.println(LargestTree.largestTree(m2));
    }

}
