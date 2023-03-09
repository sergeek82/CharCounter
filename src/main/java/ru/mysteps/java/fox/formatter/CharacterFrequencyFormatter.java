package ru.mysteps.java.fox.formatter;

import ru.mysteps.java.fox.expressions.FormatVersion;

import java.util.Map;
import java.util.Set;

public class CharacterFrequencyFormatter implements CharFormatter<String, Character, Integer> {
    @Override
    public String format(Map<Character, Integer> raws) {
        StringBuilder collector = new StringBuilder();
        Set<Map.Entry<Character, Integer>> entrySet = raws.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            collector.append(String.format(FormatVersion.OFFICIAL.getVersion(), key, val));
        }
        return collector.toString();
    }
}
