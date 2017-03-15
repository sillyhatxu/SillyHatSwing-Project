package com.sillyhat.learningenglish.utils.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * 后发现的轻量级缓存，本项目没有使用
 *
 * @author 徐士宽
 * @date 2017/3/15 16:41
 */
public class JDKCache<K, V> {

    public static final int fifo_policy = 1;//先进先出
    public static final int lru_policy = 2;//最近最少使用
    private static final int capcity = 10;
    private final Map<K, V> cacheObjects;

    public JDKCache() {
        this(capcity);
    }

    public JDKCache(final int size) {
        this(size, fifo_policy);
    }

    public JDKCache(final int size, final int policy) {
        switch (policy) {
            case fifo_policy:
                cacheObjects = new LinkedHashMap<K, V>(size) {
                    private static final long serialVersionUID = 1L;

                    @Override
                    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
                        return size() > size;
                    }
                };
                break;
            case lru_policy:
                cacheObjects = new LinkedHashMap<K, V>(size, 0.75f, true) {

                    private static final long serialVersionUID = 1L;

                    @Override
                    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
                        return size() > size;
                    }
                };
                break;
            default:
                throw new IllegalArgumentException("未知的策略:" + policy);
        }
    }

    public void put(K k, V v) {
        cacheObjects.put(k, v);
    }

    public V get(K k) {
        return cacheObjects.get(k);
    }

    public void move(K k) {
        cacheObjects.remove(k);
    }

    public void clear() {
        cacheObjects.clear();
    }

    public void forEach() {
        cacheObjects.forEach(new BiConsumer(){
            public void accept(Object k, Object y) {
                System.out.println(k + "---" + y);
            }
        });
    }


    public static void main(String[] args) {
        JDKCache<Integer, Integer> caches = new JDKCache<>(10, fifo_policy);
        for (int i = 0; i < 15; i++) {
            caches.put(i, i);
        }
        caches.forEach();
    }
}
