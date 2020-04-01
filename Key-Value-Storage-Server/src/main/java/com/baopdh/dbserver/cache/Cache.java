/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baopdh.dbserver.cache;

import com.baopdh.dbserver.IService;
import com.baopdh.dbserver.util.ConfigGetter;

/**
 *
 * @author cpu60019
 */
public class Cache<K, V> implements IService<K, V> {
    private static final int DEFAULT_CACHE_SIZE = 1000;

    IService<K, V> cacheEntity;
    
    public Cache() {
        this.cacheEntity = new LRUCache<K, V>(ConfigGetter.getInt("db.cache.size", DEFAULT_CACHE_SIZE));
    }
    
    public Cache(IService<K, V> cache) {
        this.cacheEntity = cache;
    }
    
    @Override
    public V get(K key) {
        System.out.println("cache get " + key);
        return this.cacheEntity.get(key);
    }
    
    @Override
    public boolean put(K key, V value) {
        System.out.println("cache put " + key);
        return this.cacheEntity.put(key, value);
    }
    
    @Override
    public boolean remove(K key) {
        System.out.println("cache delete " + key);
        return this.cacheEntity.remove(key);
    }
}