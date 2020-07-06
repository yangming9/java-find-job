package com.ym.learn.demo.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();

        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 自定义缓存
     */
    static class MyCache {
        private volatile Map<String, Object> map = new HashMap<>();

        public void put(String key, Object value) {
            System.out.println(Thread.currentThread().getName() + "write" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "write ok");
        }

        public void get(String key) {
            System.out.println(Thread.currentThread().getName() + "read" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "read ok");
        }
    }

    //写入时候只希望同时只有一个线程写
    static class MyCacheLock {
        private volatile Map<String, Object> map = new HashMap<>();
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        public void put(String key, Object value) {
            readWriteLock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "write" + key);
                map.put(key, value);
                System.out.println(Thread.currentThread().getName() + "write ok");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readWriteLock.writeLock().unlock();
            }

        }

        public void get(String key) {
            System.out.println(Thread.currentThread().getName() + "read" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "read ok");
        }
    }
}
