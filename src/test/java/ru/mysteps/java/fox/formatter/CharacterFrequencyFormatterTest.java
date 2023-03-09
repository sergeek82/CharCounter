package ru.mysteps.java.fox.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharacterFrequencyFormatterTest {
    private CharFormatter<String, Character, Integer> charFormatter;
    private static final String EXP_STRING = "\"a\" = 2\n";
    private static final Character TEST_CHARACTER_A = 'a';
    private static final Integer TEST_NUMBER_TWO = 2;

    @BeforeEach
    void init() {
        charFormatter = new CharacterFrequencyFormatter();
    }

    private Map<Character, Integer> getMap() {
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put(TEST_CHARACTER_A, TEST_NUMBER_TWO);
        return map;
    }

    @Test
    void format() {
        assertEquals(EXP_STRING, charFormatter.format(getMap()));
    }
}