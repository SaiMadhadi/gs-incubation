package com.gs.incubation.task10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueTuples {

    public static Set<String> uniqueTuples(String input, int len) {
        if (input == null || input.isEmpty() || len <= 0)
            throw new IllegalArgumentException("Invalid i/p");
        HashSet<String> tuples = new LinkedHashSet<>();
        for (int i = 0; i <= input.length() - len; i++) {
            tuples.add(input.substring(i, i + len));
        }
        return tuples;
    }

    public static void main(String[] args) {
        System.out.println(uniqueTuples("abadhabc", 2));
    }
}
