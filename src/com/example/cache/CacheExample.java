package com.example.cache;

import java.io.IOException;

public class CacheExample {

    public static void main(String[] args) throws IOException {
        LRUCache<String> cache = new LRUCache<>(2);
        cache.putKey("one", "1");
        System.out.println(cache.getKey("one").orElse(null));
        System.out.println(cache.getKey("one").orElse(null));
        System.out.println(cache.getKey("two").orElse(null));

        cache.deleteKey("one");
        System.out.println(cache.getKey("one").orElse(null));

        cache.putKey("one", "1");
        cache.putKey("two", "2");
        cache.putKey("three", "3");
        System.out.println(cache.getKey("one").orElse(null));
        System.out.println(cache.getKey("two").orElse(null));
        System.out.println(cache.getKey("three").orElse(null));
        System.out.println(cache.getKey("four").orElse(null));

        cache.deleteKey("two");
        System.out.println(cache.getKey("one").orElse(null));
        System.out.println(cache.getKey("two").orElse(null));
        System.out.println(cache.getKey("three").orElse(null));
        cache.deleteKey("one");
        System.out.println(cache.getKey("one").orElse(null));
        System.out.println(cache.getKey("two").orElse(null));
        System.out.println(cache.getKey("three").orElse(null));
        cache.deleteKey("three");
        System.out.println(cache.getKey("one").orElse(null));
        System.out.println(cache.getKey("two").orElse(null));
        System.out.println(cache.getKey("three").orElse(null));
    }
}
