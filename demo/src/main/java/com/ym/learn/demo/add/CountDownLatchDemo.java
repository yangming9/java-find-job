package com.ym.learn.demo.add;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        //总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
            }, String.valueOf(i)).start();
        }
        countDownLatch.countDown();
    }
}
