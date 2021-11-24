package com.gs.incubation.task5;

public class SecondSmallest {

    public static int secondSmallest(int[] x) {
        if (x == null || x.length <= 1) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        int size = x.length, min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (x[i] < min) {
                secMin = min;
                min = x[i];
            } else if (x[i] < secMin && x[i] != min) {
                secMin = x[i];
            }
        }

        if (secMin == Integer.MAX_VALUE) {
            return 0;
        }
        return secMin;
    }

    public static void main(String[] args) {
        System.out.println("Second smallest in an array : "+ SecondSmallest.secondSmallest(new int[]{4,5,1,1,8}));
    }
}
