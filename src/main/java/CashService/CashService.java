package CashService;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class CashService implements Cash {

    private ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();
    private LinkedList<String> keysList = new LinkedList();

    @Override
    public Object get(String key) {
        Object object = cache.get(key);
        if (object != null) {
            return object;
        }
        return cache.computeIfAbsent(key, k -> new Object());
    }

    @Override
    public Object put(String key, Object value) {
        Object ret;
        synchronized (cache) {
            ret = cache.get(key);
            if (ret == null) {
                keysList.add(key);
                ret = cache.putIfAbsent(key, value);
                if (ret == null) {
                    eviction();
                    ret = value;
                }
            }
        }
        return ret;
    }

    private void eviction() {
        if (cache.size() > 100_000) {
            String key = keysList.get(0);
            keysList.remove(0);
            cache.remove(key);
        }
    }

}