package com.ym.learn.demo.locks;

/**
 * 可重入锁
 * 可以进行嵌套调用
 * 如果不可以进行嵌套调用，这样setB()会一直拿不到锁，会造成死锁
 */
public class Lock1 {
    synchronized void setA() throws Exception {
        Thread.sleep(1000);
        setB();
    }

    synchronized void setB() throws Exception {
        Thread.sleep(1000);
    }
}
