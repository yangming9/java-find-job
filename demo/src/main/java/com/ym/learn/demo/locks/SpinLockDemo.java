package com.ym.learn.demo.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "===> mylock");

        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println("wait for suo");
        }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "===> myUnlock");

        atomicReference.compareAndSet(thread, null);
        System.out.println("release for suo");
    }
}
