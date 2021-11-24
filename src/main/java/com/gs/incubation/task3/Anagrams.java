package com.gs.incubation.task3;

import java.util.*;

public class Anagrams {

    public static Set<Set<String>> group(List<String> words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        Map<String, Set<String>> anagramsGroup = new HashMap<>();
        for (String word : words) {
            char[] wordArray = word.toLowerCase().toCharArray();
            Arrays.sort(wordArray);
            String sortedWord = new String(wordArray);
            if (anagramsGroup.containsKey(sortedWord)) {
                anagramsGroup.get(sortedWord).add(word);
            } else {
                Set<String> set = new HashSet<>();
                set.add(word);
                anagramsGroup.put(sortedWord, set);
            }
        }
        return new HashSet<>(anagramsGroup.values());
    }
}
