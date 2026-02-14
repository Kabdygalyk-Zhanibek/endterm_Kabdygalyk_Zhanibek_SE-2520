package petterns;

import java.util.HashMap;
import java.util.Map;

public class CacheManager { //new class (cache)
    private static CacheManager instance;
    private final Map<String, Object> cache = new HashMap<>();

    private CacheManager() {}

    public static synchronized CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public boolean contains(String key) {
        return cache.containsKey(key);
    }

    public void clear() {
        cache.clear();
    }
}
