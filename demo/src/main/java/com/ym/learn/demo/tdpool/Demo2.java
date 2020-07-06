package com.ym.learn.demo.tdpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0;i<9;i++){
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName()+ "ok");
            });
        }
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
