package com.leejt.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName LockExample3
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/14 9:45
 * @Version 1.0
 **/
@Slf4j
public class LockExample3 {
    private final Map<String,Data> map = new TreeMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public Data get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKey(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }

    public Data put(String key, Data data){
        writeLock.lock();
        try {
            return map.put(key,data);
        }finally {
            writeLock.unlock();
        }
    }
    class Data{

    }
}
