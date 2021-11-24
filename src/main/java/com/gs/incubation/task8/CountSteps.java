package com.gs.incubation.task8;

public class CountSteps {

    public static Integer countSteps(Integer n) {
        if (n == null)
            throw new IllegalArgumentException("Invalid i/p");
        if (n < 0)
            return 0;
        int[] count = new int[n > 3 ? n + 1 : 4];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        count[3] = 4;
        if (n <= 3)
            return count[n];
        for (int i = 4; i <= n; i++)
            count[i] = count[i - 1] + count[i - 2] + count[i - 3];
        return count[n];
    }

    public static void main(String[] args) {
        System.out.println(CountSteps.countSteps(3));
        System.out.println(CountSteps.countSteps(1));
        System.out.println(CountSteps.countSteps(2));
        System.out.println(CountSteps.countSteps(10));
    }
}
