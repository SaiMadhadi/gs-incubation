package com.gs.incubation.task3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DictionarySearch {

    public static Set<String> longestWord(String letters, Dictionary dictionary) {
        if (letters == null || dictionary == null || dictionary.words == null) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        String[] words = dictionary.words;
        int maxLength = -1;
        Set<String> ans = new HashSet<>();
        Map<Character, Integer> charFrequency;
        for (String word : words) {
            charFrequency = new HashMap<>();
            for (char ch : word.toCharArray()) {
                if (charFrequency.containsKey(ch)) {
                    charFrequency.put(ch, charFrequency.get(ch) + 1);
                } else {
                    charFrequency.put(ch, 1);
                }
            }
            for (char ch : letters.toCharArray()) {
                if (charFrequency.containsKey(ch)) {
                    int newFrequency = charFrequency.get(ch) - 1;
                    if (newFrequency == 0) {
                        charFrequency.remove(ch);
                    } else {
                        charFrequency.put(ch, newFrequency);
                    }
                }
            }
            if (charFrequency.isEmpty()) {
                if (word.length() > maxLength) {
                    ans = new HashSet<>();
                    ans.add(word);
                    maxLength = word.length();
                } else if (word.length() == maxLength) {
                    ans.add(word);
                }
            }
        }
        return ans;
    }
}
