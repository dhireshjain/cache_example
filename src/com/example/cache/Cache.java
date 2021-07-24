package com.example.cache;

import java.util.Map;
import java.util.Optional;

/*
 Base class for Cache implementation
 Map keeps track of keys and points to values stored in queue
 Queue stores the cache values in the order defined by the cache implementation
 */
public abstract class Cache<V> {
    protected Map<String, Node<V>> map;
    protected CacheQueue<V> queue;
    protected int capacity;

    protected Cache(int capacity) {
        this.capacity = capacity;
    }

    public abstract Optional<V> getKey(String key);

    public abstract boolean putKey(String key, V value);

    public abstract boolean deleteKey(String key);
}

