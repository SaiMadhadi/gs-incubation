package com.gs.incubation.task4;

public class ReverseStringBug {

    public static String reverseStr(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        char[] inputCharArray = str.toCharArray();
        char ch;
        int i = 0, j = inputCharArray.length - 1;
        while (i < j) {
            ch = inputCharArray[i];
            inputCharArray[i] = inputCharArray[j];
            inputCharArray[j] = ch;
            i++;
            j--;
        }
        return new String(inputCharArray);
    }
}
