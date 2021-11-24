package com.gs.incubation.task10;

public class SnowTrapping {

    public static Integer computeSnowPack(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        int left = 0, right = arr.length - 1, maxLeft = 0, maxRight = 0, ans = 0;
        while (left <= right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > maxLeft) {
                    maxLeft = arr[left];
                } else {
                    ans += maxLeft - arr[left];
                }
                left++;
            } else {
                if (arr[right] > maxRight) {
                    maxRight = arr[right];
                } else {
                    ans += maxRight - arr[right];
                }
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(computeSnowPack(new int[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}));
        System.out.println(computeSnowPack(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}));
        System.out.println(computeSnowPack(new int[]{0, 1, 0, 3}));
    }
}
