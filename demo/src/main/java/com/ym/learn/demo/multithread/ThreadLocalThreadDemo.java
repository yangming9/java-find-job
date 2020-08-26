package com.ym.learn.demo.multithread;

import java.util.ArrayList;

public class ThreadLocalThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalBank bank = new ThreadLocalBank();
        System.out.println("原始值: "+bank.getAccount());
        ArrayList<Thread> list = new ArrayList<>();

        for (int i=0;i<10;i++){
            list.add(new Thread(new ThreadLocalThread(bank)));
        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }
        System.out.println("运行后的值： "+bank.getAccount());
    }
}
