package com.ym.learn.demo.multithread;

public class ThreadLocalThread implements Runnable{
    private ThreadLocalBank threadLocalBank;

    public ThreadLocalThread(ThreadLocalBank threadLocalBank) {
        this.threadLocalBank = threadLocalBank;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            threadLocalBank.save(i);
        }
        System.out.println("ThreadLocal中的值："+threadLocalBank.getAccount());
    }
}
