package com.ym.learn.demo.function;

import java.util.concurrent.atomic.AtomicInteger;

public class VDemo {
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add(){
        num.getAndIncrement();//不是原子性操作
    }

    public static void main(String[] args) {
        for (int i = 0;i<20;i++){
            new Thread(() -> {
                for (int j = 0;j<1000;j++){
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
