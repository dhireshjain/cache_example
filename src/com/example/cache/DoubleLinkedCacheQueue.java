package com.example.cache;

public class DoubleLinkedCacheQueue<V> implements CacheQueue<V> {
    Node<V> head;
    Node<V> tail;
    int size;

    private void init(Node<V> node) {
        this.head = this.tail = node;
        this.size = 1;
    }

    private void reset() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public boolean addHead(Node<V> node) {
        if(isEmpty()) {
            init(node);
        } else {
            Node<V> currHead = this.head;
            currHead.next = node;
            node.prev = currHead;
            this.head = node;
            size++;
        }
        return false;
    }

    public boolean removeNode(Node<V> node) {
        if(size == 1) {
            reset();
        } else {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node == head) {
                this.head = this.head.prev;
            }
            if (node == tail) {
                this.tail = this.tail.next;
            }
            size--;
        }
        return false;
    }

    public Node<V> removeTail() {
        Node<V> currentTail = this.tail;
        removeNode(this.tail);
        return currentTail;
    }

    public int getSize() {
        return this.size;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }
}
