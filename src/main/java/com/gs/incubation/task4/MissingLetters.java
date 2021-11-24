package com.gs.incubation.task4;

public class MissingLetters {

    public static String findMissingLetters(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        char[] sentenceCharArray = sentence.toCharArray();
        int[] letterCounter = new int[26];
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < sentenceCharArray.length; i++) {
            if (sentenceCharArray[i] >= 97 && sentenceCharArray[i] <= 122)
                letterCounter[sentenceCharArray[i] - 97]++;
            else if (sentenceCharArray[i] >= 65 && sentenceCharArray[i] <= 90) {
                letterCounter[sentenceCharArray[i] - 65]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (letterCounter[i] == 0) {
                resultString.append((char) (i + 97));
            }
        }
        return new String(resultString);
    }
}
