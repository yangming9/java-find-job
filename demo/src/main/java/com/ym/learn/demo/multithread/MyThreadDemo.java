package com.ym.learn.demo.multithread;

import java.util.ArrayList;

public class MyThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        System.out.println("原始值："+bank.getAccount());
        ArrayList<Thread> list = new ArrayList<>();
        for (int i =0;i<1000;i++){
            list.add(new Thread(new MyThread(bank)));
        }
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println("运行之后："+bank.getAccount());
    }
}
