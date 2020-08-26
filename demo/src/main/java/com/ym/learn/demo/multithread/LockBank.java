package com.ym.learn.demo.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBank {
    private int account = 0;
    private Lock lock = new ReentrantLock();//声明这个可重入锁

    public int getAccount() {
        return account;
    }

    public void save(int money){
        lock.lock();
        try {
            account += money;
        }finally {
            lock.unlock();
        }
    }
}
