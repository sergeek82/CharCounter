package ru.mysteps.java.fox.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCacheTest {
    private Cache<String, Character, Integer> testCache;
    private static final String TEST_CHARACTER_A = "a";

    @BeforeEach
    void init() {
        testCache = new SimpleCache();
    }

    @Test
    void processShouldCheckGetMethod() {
        testCache.putCached(TEST_CHARACTER_A, new LinkedHashMap<>());
        assertEquals(new LinkedHashMap<>(), testCache.getCached(TEST_CHARACTER_A));
    }

    @Test
    void processShouldCheckIsPresentMethod() {
        testCache.putCached(TEST_CHARACTER_A, new LinkedHashMap<>());
        assertTrue(testCache.isPresent(TEST_CHARACTER_A));
    }
}