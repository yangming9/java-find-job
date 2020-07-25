package com.ym.learn.demo.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 不可重入锁
 */
public class Lock2 {
    private AtomicReference<Thread> owner = new AtomicReference<>();
    private void lock(){
        Thread current = Thread.currentThread();
        //很经典的自旋语法 AtomicInteger中也有
        while (!owner.compareAndSet(null,current)){
            System.out.println("wait for suo");
        }
    }

    private void unlock(){
        Thread current = Thread.currentThread();
        if (current == owner.get())
        owner.compareAndSet(current,null);
    }

    public static void main(String[] args) {
        Lock2 lock2 = new Lock2();
        lock2.lock();
//        lock2.unlock();
        lock2.lock();
    }
}
