package ru.mysteps.java.fox.cache;

import java.util.Map;

public interface Cache<T, K, V> {
    Map<K, V> getCached(T inString);

    void putCached(T inString, Map <K,V> raws);

    boolean isPresent(T inString);
}
