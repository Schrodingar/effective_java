package CashService;

import java.util.concurrent.ConcurrentHashMap;

public class CashService implements Cash{

    private ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    @Override
    public Object get(String key)
    {
        Object object = cache.get(key);
        if (object != null) {
            return object;
        }
        return cache.computeIfAbsent(key, k -> new Object());
    }

    @Override
    public Object put(String key, Object value) {
        Object ret;
        synchronized(cache) {
            ret = cache.get(key);
            if (ret == null) {
                ret = cache.putIfAbsent(key, value);
                if (ret == null) {
                    ret = value;
                }
            }
        }
        return ret;
    }

}