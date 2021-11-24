package com.gs.incubation.task9;

import java.util.Arrays;

public class MinimalSteps {

    private static Integer minimalSteps(String ingredients) {
        if (ingredients == null || ingredients.isEmpty()) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        int[] size = new int[ingredients.length()];
        Arrays.fill(size, Integer.MAX_VALUE);
        size[0] = 1;
        for (int i = 1; i < ingredients.length(); i++) {
            if ((2 * i) <= ingredients.length() && ingredients.substring(0, i).equals(ingredients.substring(i, (2 * i)))) {
                size[(2 * i) - 1] = size[i - 1] + 1;
            }
            size[i] = Math.min(size[i], size[i - 1] + 1);
        }
        return size[ingredients.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(minimalSteps("ABABCABABCD"));
        System.out.println(minimalSteps("ABCABCE"));
        System.out.println(minimalSteps("ABCDABCE"));
        System.out.println(minimalSteps("ABABABAB"));
        System.out.println(minimalSteps("A"));
    }

}
