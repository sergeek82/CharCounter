package ru.mysteps.java.fox.facade;

import ru.mysteps.java.fox.cache.Cache;
import ru.mysteps.java.fox.formatter.CharFormatter;
import ru.mysteps.java.fox.calculator.Calculator;

public class CharCounter {
    private final Calculator calculator;
    private final CharFormatter<String, Character, Integer> charFormatter;
    private final Cache<String, Character, Integer> cache;

    public CharCounter(Calculator calculator,
                       CharFormatter<String, Character, Integer> charFormatter, Cache<String,Character,Integer> cache) {
        this.calculator = calculator;
        this.charFormatter = charFormatter;
        this.cache = cache;
    }

    public String count(String inString) {
        if (!cache.isPresent(inString)) {
            cache.putCached(inString, calculator.calculate(inString));
        }
        return charFormatter.format(cache.getCached(inString));
    }
}
