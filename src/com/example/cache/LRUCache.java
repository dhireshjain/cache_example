package com.example.cache;

import java.util.HashMap;
import java.util.Optional;

/*
  Cache implementation that evicts the least recently used key from the queue when needed
 */
public class LRUCache<V> extends Cache<V> {

    private static final int DEFAULT_CAPACITY = 10;

    public LRUCache() {
        this(DEFAULT_CAPACITY);
    }

    public LRUCache(int capacity) {
        super(capacity);
        this.map = new HashMap<>();
        this.queue = new DoubleLinkedCacheQueue<>();
    }

    @Override
    public Optional<V> getKey(String key) {
        if (this.map.containsKey(key)) {
            Node<V> node = this.map.get(key);
            evictFromCache(key);
            addToCache(key, node);
            return Optional.of(node.getValue());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean putKey(String key, V value) {
        if (this.map.containsKey(key)) {
            evictFromCache(key);
        }
        Node<V> node = new Node<>(key, value);
        addToCache(key, node);
        executeEvictPolicy();
        return true;
    }

    @Override
    public boolean deleteKey(String key) {
        if (this.map.containsKey(key)) {
            evictFromCache(key);
            return true;
        } else {
            return false;
        }
    }

    private void addToCache(String key, Node<V> node) {
        this.queue.addHead(node);
        this.map.put(key, node);
    }

    private void evictFromCache(String key) {
        this.queue.removeNode(map.get(key));
        this.map.remove(key);
    }
    private void executeEvictPolicy() {
        // Queue is full, remove LRU key
        if (this.isCacheFull()) {
            Node<V> previousTail = this.queue.removeTail();
            this.map.remove(previousTail.getKey());
        }
    }

    private boolean isCacheFull() {
        return this.queue.getSize() > this.capacity;
    }
}

