package com.gs.incubation.task4;

public class RunLengthEncoding {

    public static String rle(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        char[] inputCharArray = input.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (int i = 0, j = 0; i < inputCharArray.length; i++) {
            while (inputCharArray[i] == inputCharArray[j]) {
                j++;
                if (j == inputCharArray.length)
                    break;
            }
            resultString.append(inputCharArray[i] + "" + (j - i));
            i = j - 1;
        }
        return new String(resultString);
    }
}
