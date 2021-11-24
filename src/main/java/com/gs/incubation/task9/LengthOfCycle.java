package com.gs.incubation.task9;

import java.util.HashMap;
import java.util.Map;

public class LengthOfCycle {

    private static int countLengthOfCycle(int[] arr, int startIndex) {
        if (arr == null || arr.length == 0 || startIndex < 0 || startIndex > arr.length) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        int currentIndex = startIndex, count = 1;
        Map<Integer, Integer> lengthMap = new HashMap<>();
        while (currentIndex < arr.length) {
            if (lengthMap.containsKey(currentIndex)) {
                return count - lengthMap.get(currentIndex);
            }
            lengthMap.put(currentIndex, count);
            currentIndex = arr[currentIndex];
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(LengthOfCycle.countLengthOfCycle(new int[]{1, 2, 0}, 0));
        System.out.println(LengthOfCycle.countLengthOfCycle(new int[]{1, 0}, 0));
        System.out.println(LengthOfCycle.countLengthOfCycle(new int[]{1, 1}, 0));
        System.out.println(LengthOfCycle.countLengthOfCycle(new int[]{1, 3, 2, 0, 1}, 1));
    }
}
