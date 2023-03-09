package ru.mysteps.java.fox.calculator;

import java.util.*;

public class Calculator {
    public Map<Character, Integer> calculate(String inString) {
        Set<Character> uniqueChars;
        Map<Character, Integer> raws = new LinkedHashMap<>();
        Character[] chLetters = new Character[inString.length()];

        for (int i = 0; i < inString.length(); i++) {
            chLetters[i] = inString.charAt(i);
        }

        uniqueChars = new LinkedHashSet<>(Arrays.asList(chLetters));

        for (Character unique : uniqueChars) {
            Integer match = 0;
            for (Character temp : chLetters) {
                if (unique.equals(temp)) {
                    match++;
                }
            }
            raws.put(unique, match);
        }
        return raws;
    }
}
