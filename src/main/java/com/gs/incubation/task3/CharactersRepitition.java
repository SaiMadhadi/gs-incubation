package com.gs.incubation.task3;

import java.util.HashMap;
import java.util.Map;

public class CharactersRepitition {

    public static char findFirst(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        Map<Character, Integer> characterFrequency = new HashMap<>();
        char[] charactersInInput = input.toCharArray();
        for (Character ch : charactersInInput) {
            if (characterFrequency.containsKey(ch)) {
                characterFrequency.put(ch, characterFrequency.get(ch) + 1);
            } else {
                characterFrequency.put(ch, 1);
            }
        }
        for (Character ch : charactersInInput) {
            if (characterFrequency.get(ch) == 1)
                return ch;
        }
        return '0';
    }
}
