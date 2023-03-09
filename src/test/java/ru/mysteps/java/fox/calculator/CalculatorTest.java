package ru.mysteps.java.fox.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    private static final String EXP_STRING = "abbc";
    private static final Character TEST_CHARACTER_A = 'a';
    private static final Character TEST_CHARACTER_B = 'b';
    private static final Character TEST_CHARACTER_C = 'c';
    private static final Integer TEST_NUMBER_ONE = 1;
    private static final Integer TEST_NUMBER_TWO = 2;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    private Map<Character, Integer> getTestData() {
        Map<Character, Integer> filledMap = new LinkedHashMap<>();
        filledMap.put(TEST_CHARACTER_A, TEST_NUMBER_ONE);
        filledMap.put(TEST_CHARACTER_B, TEST_NUMBER_TWO);
        filledMap.put(TEST_CHARACTER_C, TEST_NUMBER_ONE);
        return filledMap;
    }

    @Test
    void processShouldReturnRightMap() {
        assertEquals(getTestData(), calculator.calculate(EXP_STRING));
    }
}