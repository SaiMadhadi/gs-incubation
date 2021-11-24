package com.gs.incubation.task10;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static int pascal(int col, int row) {
        if (col == 0 || col == row || row <= 1)
            return 1;
        if (col > row)
            throw new IllegalArgumentException();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        prev.add(1);
        List<Integer> curr;
        int t1, t2;
        for (int i = 2; i <= row; i++) {
            curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                t1 = j - 1 >= 0 ? prev.get(j - 1) : 0;
                t2 = j < prev.size() ? prev.get(j) : 0;
                curr.add(t1 + t2);
            }
            prev = curr;
        }
        return prev.get(col);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(pascal(j, i) + " ");
            System.out.println();
        }
    }
}
