package com.gs.incubation.task3;

public class DistanceBetweenWords {

    public static double shortestDistance(String document, String word1, String word2) {
        if (document == null || word1 == null || word2 == null) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        String[] lines = document.split("[,.]");
        double distance = -1, word1Pos = -1, word2Pos = -1;
        int currentIndex = 0;
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.equalsIgnoreCase(word1)) {
                    word1Pos = currentIndex + (word1.length() / 2.0);
                } else if (word.equalsIgnoreCase(word2)) {
                    word2Pos = currentIndex + (word2.length() / 2.0);
                } else ;
                if (word1Pos != -1 && word2Pos != -1) {
                    if (distance == -1) {
                        distance = Math.abs(word1Pos - word2Pos);
                    } else if (Math.abs(word1Pos - word2Pos) < distance) {
                        distance = Math.abs(word1Pos - word2Pos);
                    }
                }
                currentIndex += word.length() + 1;
            }
        }
        return distance;
    }
}
