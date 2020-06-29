package cn.liuliang.javaeesys.utils;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 项目缓存
 *
 * @author liuliang-刘亮
 * @date 2020/6/21 - 20:34
 */
@Component
public class MyCache {

    private  volatile Map<String, Object> cache = new ConcurrentHashMap<>(16);

    public  void add(String key, Object values) {
        cache.put(key, values);
    }

    public  Object get(String key) {
        return cache.get(key);
    }

    public void remove(String key){
        cache.remove(key);
    }

}
