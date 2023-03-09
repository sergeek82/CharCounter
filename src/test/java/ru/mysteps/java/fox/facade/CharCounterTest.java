package ru.mysteps.java.fox.facade;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import ru.mysteps.java.fox.cache.Cache;
import ru.mysteps.java.fox.cache.SimpleCache;
import ru.mysteps.java.fox.calculator.Calculator;
import ru.mysteps.java.fox.formatter.CharFormatter;
import ru.mysteps.java.fox.formatter.CharacterFrequencyFormatter;

class CharCounterTest {
    private static Calculator calculator;
    private static CharFormatter<String, Character, Integer> charFormatter;
    private static CharCounter charCounter;
    private static Cache<String, Character, Integer> cache;

    @BeforeAll
    static void init() {
        calculator = mock(Calculator.class);
        charFormatter = mock(CharacterFrequencyFormatter.class);
        cache = mock(SimpleCache.class);
        charCounter = new CharCounter(calculator, charFormatter, cache);
    }

    @Test
    void processShouldCheckInvocationWhenCacheIsFilled() {
        when(cache.isPresent(anyString())).thenReturn(true);
        charCounter.count(anyString());
        verify(calculator, never()).calculate(anyString());
        verify(cache, never()).putCached(anyString(), anyMap());
        verify(charFormatter, times(1)).format(anyMap());
        verify(cache, times(1)).isPresent(anyString());
        verify(cache, times(1)).getCached(anyString());
    }

    @Test
    void processShouldCheckInvocationWhenCacheIsEmpty() {
        when(cache.isPresent(anyString())).thenReturn(false);
        charCounter.count(anyString());
        verify(calculator, times(1)).calculate(anyString());
        verify(cache, times(1)).putCached(anyString(), anyMap());
        verify(charFormatter, times(2)).format(anyMap());
        verify(cache, times(2)).isPresent(anyString());
        verify(cache, times(2)).getCached(anyString());
    }
}