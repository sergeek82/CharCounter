package ru.mysteps.java.fox.formatter;

import java.util.Map;

public interface CharFormatter<T, K, V> {
    T format(Map<K, V> raws);
}
