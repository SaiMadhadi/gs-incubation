package com.gs.incubation.task7;

public class ShortestSubArray {

    public static int subArrayExceedsSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < arr.length) {
            sum += arr[j];
            while (i <= j && sum > target) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                }
                sum -= arr[i];
                i++;
            }
            j++;
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(ShortestSubArray.subArrayExceedsSum(new int[]{1, 2, 3, 4}, 12));
        System.out.println(ShortestSubArray.subArrayExceedsSum(new int[]{1, 2, 3, 4}, 0));
        System.out.println(ShortestSubArray.subArrayExceedsSum(new int[]{1, 2, 3, 4}, 5));
        System.out.println(ShortestSubArray.subArrayExceedsSum(new int[]{1, 2, 3, 4}, 2));
    }
}
