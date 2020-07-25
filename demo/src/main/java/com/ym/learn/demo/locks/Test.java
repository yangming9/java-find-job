package com.ym.learn.demo.locks;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        //底层使用CAS
        SpinLockDemo lock = new SpinLockDemo();

        new Thread(() -> {
            lock.mylock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }
        },"T1").start();

        new Thread(() -> {
            lock.mylock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.myUnlock();
            }
        },"T2").start();

    }
}
