package com.ym.learn.demo.function;

import java.util.concurrent.TimeUnit;

public class JMMDemo {
    private static int num = 0;
    public static void main(String[] args) {
        new Thread(() -> {
            while (num == 0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;

        System.out.println(num);
    }
}
