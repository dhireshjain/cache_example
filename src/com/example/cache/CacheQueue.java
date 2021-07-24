package com.example.cache;

public interface CacheQueue<V> {
    boolean addHead(Node<V> node);
    Node<V> removeTail();
    boolean removeNode(Node<V> node);
    int getSize();
}
