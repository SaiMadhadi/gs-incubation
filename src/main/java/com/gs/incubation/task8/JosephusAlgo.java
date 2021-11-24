package com.gs.incubation.task8;

public class JosephusAlgo {

    public static int whoIsElected(int n, int k) {
        if (n <= 0)
            throw new IllegalArgumentException("Invalid i/p");
        return n == 1 ? n : ((whoIsElected(n - 1, k) + k - 1) % n) + 1;
    }

    public static void main(String[] args) {
        System.out.println(JosephusAlgo.whoIsElected(4, 2));
        System.out.println(JosephusAlgo.whoIsElected(2, 2));
        System.out.println(JosephusAlgo.whoIsElected(1, 1));
        System.out.println(JosephusAlgo.whoIsElected(14, 2));
        System.out.println(JosephusAlgo.whoIsElected(2, 3));

    }

}
