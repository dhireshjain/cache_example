# cache_example
Example of a generic extendible implementation of various cache alogrithms

# Usage
```
Cache<String> cache = new LRUCache<>(2);
cache.putKey("one", "1");
System.out.println(cache.getKey("one").orElse(null));
System.out.println(cache.getKey("one").orElse(null));
System.out.println(cache.getKey("two").orElse(null));

cache.deleteKey("one");
System.out.println(cache.getKey("one").orElse(null));
```
