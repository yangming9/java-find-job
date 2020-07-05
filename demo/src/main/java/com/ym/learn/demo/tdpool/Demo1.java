package com.ym.learn.demo.tdpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        Executors.newScheduledThreadPool()

        for (int i = 0;i<100;i++){
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName()+ "ok");
            });
        }
    }
}
