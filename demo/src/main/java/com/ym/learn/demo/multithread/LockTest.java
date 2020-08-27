package com.ym.learn.demo.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private Lock lock = new ReentrantLock();
    private void lockTest(Thread thread){
        lock.lock();
        try {
            System.out.println("线程"+thread.getName()+"获取当前锁");
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("线程"+thread.getName()+"发生了异常释放锁");
        }finally {
            System.out.println("线程"+thread.getName()+"执行完毕释放锁");
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        //声明一个线程
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.lockTest(Thread.currentThread());
            }
        },"thread1");
        //声明一个线程 线程2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.lockTest(Thread.currentThread());
            }
        },"thread2");
        thread1.start();
        thread2.start();
    }
}
