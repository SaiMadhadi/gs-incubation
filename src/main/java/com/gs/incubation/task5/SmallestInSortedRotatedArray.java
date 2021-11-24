package com.gs.incubation.task5;

public class SmallestInSortedRotatedArray {

    public static int findMin(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        int l = 0, h = a.length - 1, mid = 0;
        while (l <= h) {
            mid = (l + h) / 2;
            if (a[mid] < a[l] && a[mid] < a[h]) {
                return a[mid];
            } else if (a[mid] > a[h]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return a[mid];
    }

    public static void main(String[] args) {
        System.out.println("Smallest in sorted rotated : " + SmallestInSortedRotatedArray.findMin(new int[]{4, 5, 6, 7, -1, 0, 3}));
    }
}
