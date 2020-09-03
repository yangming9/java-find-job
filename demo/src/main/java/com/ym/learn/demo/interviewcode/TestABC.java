package com.ym.learn.demo.interviewcode;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TestABC {
    public static void main(String[] args) {
        CountDownLatch countDownLatchA = new CountDownLatch(1);
        CountDownLatch countDownLatchB = new CountDownLatch(1);
        CountDownLatch countDownLatchC = new CountDownLatch(1);
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                countDownLatchA.countDown();
            }
        },"threadA");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatchA.await();
                    Thread.sleep(new Random().nextInt(1000));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                countDownLatchB.countDown();
            }
        },"threadB");

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatchB.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                countDownLatchC.countDown();
            }
        },"threadC");

        threadA.start();
        threadB.start();
        threadC.start();

        
    }
}
