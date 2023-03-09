package ru.mysteps.java.fox.cache;

import java.util.HashMap;
import java.util.Map;

public class SimpleCache implements Cache<String, Character, Integer> {
    private final Map<String, Map<Character, Integer>> cached = new HashMap<>();

    @Override
    public Map<Character,Integer> getCached(String inString) {
        return cached.get(inString);
    }

    @Override
    public void putCached(String inString, Map<Character, Integer> raws) {
        this.cached.put(inString, raws);
    }

    @Override
    public boolean isPresent(String inString) {
        return cached.containsKey(inString);
    }
}
