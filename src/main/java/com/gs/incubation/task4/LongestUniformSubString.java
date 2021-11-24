package com.gs.incubation.task4;

public class LongestUniformSubString {

    public static String longestUniformSubstring(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        int start = -1, end = -1;
        char[] inputCharArray = input.toCharArray();
        for (int i = 0, j = 0; i < inputCharArray.length; i++) {
            while (inputCharArray[i] == inputCharArray[j]) {
                j++;
                if (j == inputCharArray.length)
                    break;
            }
            if (j - i > end - start) {
                start = i;
                end = j;
            }
            i = j - 1;
        }
        return input.substring(start, end);
    }
}
