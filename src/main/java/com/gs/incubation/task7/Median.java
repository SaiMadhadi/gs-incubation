package com.gs.incubation.task7;

public class Median {

    public static double findMedianSortedArraysInLinearTimed(int[] a, int[] b) {
        if (a == null || b == null || (a.length == 0 && b.length == 0)) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        int medianPos = (a.length + b.length) / 2;
        boolean isOdd = (a.length + b.length) % 2 == 1, isFinished = false;
        int i = 0, j = 0;
        double temp1 = 0.0, temp2 = 0.0, ans = 0.0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                temp1 = b[j];
                j++;
            } else {
                temp1 = a[i];
                i++;
            }
            if (isOdd && medianPos + 1 == i + j) {
                ans = temp1;
                isFinished = true;
                break;
            } else if (!isOdd && medianPos + 1 == i + j) {
                ans = (temp1 + temp2) / 2.0;
                isFinished = true;
                break;
            }
            temp2 = temp1;
        }

        while (i < a.length && !isFinished) {
            temp2 = temp1;
            temp1 = a[i];
            i++;
            if (isOdd && medianPos + 1 == i + j) {
                ans = temp1;
                isFinished = true;
                break;
            } else if (!isOdd && medianPos + 1 == i + j) {
                ans = (temp1 + temp2) / 2.0;
                isFinished = true;
                break;
            }
        }

        while (j < b.length && !isFinished) {
            temp2 = temp1;
            temp1 = b[j];
            j++;
            if (isOdd && medianPos + 1 == i + j) {
                ans = temp1;
                isFinished = true;
                break;
            } else if (!isOdd && medianPos + 1 == i + j) {
                ans = (temp1 + temp2) / 2.0;
                isFinished = true;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Median.findMedianSortedArraysInLinearTimed(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}));
        System.out.println(Median.findMedianSortedArraysInLinearTimed(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7}));
        System.out.println(Median.findMedianSortedArraysInLinearTimed(new int[]{1, 7, 10, 21}, new int[]{3, 5, 12, 20}));
        System.out.println(Median.findMedianSortedArraysInLinearTimed(new int[]{1, 7, 11, 21}, new int[]{}));
        System.out.println(Median.findMedianSortedArraysInLinearTimed(new int[]{1}, new int[]{}));
    }
}
