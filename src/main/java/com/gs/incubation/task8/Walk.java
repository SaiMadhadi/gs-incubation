package com.gs.incubation.task8;

public class Walk {

    public static Integer[] walk(String path) {
        if (path == null)
            throw new IllegalArgumentException("Invalid i/p");
        int x = 0, y = 0;
        for (Character ch : path.toCharArray()) {
            if (ch == 'U')
                y++;
            else if (ch == 'D')
                y--;
            else if (ch == 'L')
                x--;
            else if (ch == 'R')
                x++;
        }
        return new Integer[]{x, y};
    }

    public static void main(String[] args) {
        Integer[] a1 = Walk.walk("");
        System.out.println(a1[0] + " " + a1[1]);

        Integer[] a2 = Walk.walk("L");
        System.out.println(a2[0] + " " + a2[1]);

        Integer[] a3 = Walk.walk("UUU");
        System.out.println(a3[0] + " " + a3[1]);

        Integer[] a4 = Walk.walk("ULDR");
        System.out.println(a4[0] + " " + a4[1]);
    }

}


