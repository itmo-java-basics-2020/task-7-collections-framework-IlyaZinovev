package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {
    private static final float LOAD_FACTOR = 1;

    private LinkedHashMap<K, V> map;
    private final int length;

    public LruCache(int capacity) {
        length = capacity;
        map = new LinkedHashMap<>(capacity, LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > length;
            }
        };
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public int elements() {
        return map.size();
    }
}