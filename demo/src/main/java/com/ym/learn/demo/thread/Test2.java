package com.ym.learn.demo.thread;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();
        new Thread(() -> {
            phone2.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.hello();
        }, "B").start();
    }

    static class Phone2 {
        public synchronized void sendSms() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }System.out.println("sendSms");
        }

        public synchronized void call() {
            System.out.println("call");
        }

        public void hello(){
            System.out.println("Hello");
        }
    }
}
