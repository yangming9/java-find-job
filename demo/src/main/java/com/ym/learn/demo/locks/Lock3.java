package com.ym.learn.demo.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 将lock2 更改为可重入的锁
 */
public class Lock3 {

    private AtomicReference<Thread> owner = new AtomicReference<>();
    private int state = 0;

    private void lock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            state++;
            return;
        }

       while (!owner.compareAndSet(null,current)){
           System.out.println("wait for suo");
       }

    }

    private void unlock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            if (state != 0) {
                state--;
                return;
            }else {
                owner.compareAndSet(current,null);
            }
        }
    }
}
