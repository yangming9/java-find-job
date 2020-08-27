package com.ym.learn.demo.multithread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest1 {
    private Lock lock = new ReentrantLock();
    public void tryLockTest(Thread thread) throws InterruptedException {
        if (lock.tryLock(3000, TimeUnit.MILLISECONDS)){
            try {
                System.out.println("线程"+thread.getName()+"获取当前锁");
                Thread.sleep(4000);
                System.out.println(10/0);
            }catch (Exception e){
                System.out.println("线程"+thread.getName()+"发生异常释放了锁");
            }finally {
                System.out.println("线程"+thread.getName()+"执行完毕释放锁");
                lock.unlock();
                System.out.println("*******");
            }
        }else {
            System.out.println("我是线程"+Thread.currentThread().getName()+"当前锁被别人占用，我无法获取");
        }
    }

    public static void main(String[] args) {
        LockTest1 lockTest1 = new LockTest1();
        Thread thread1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                lockTest1.tryLockTest(Thread.currentThread());
            }
        },"thread1");
        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                lockTest1.tryLockTest(Thread.currentThread());
            }
        },"thread2");
        thread1.start();
        thread2.start();
    }
}
