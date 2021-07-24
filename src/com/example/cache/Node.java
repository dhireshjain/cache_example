package com.example.cache;

public class Node<T> {
    String key;
    T value;
    Node<T> prev;
    Node<T> next;

    public Node(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public T getValue() {
        return this.value;
    }
}
