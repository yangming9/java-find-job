package com.ym.learn.demo.multithread;

import java.util.ArrayList;

public class LockThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        LockBank lockBank = new LockBank();
        System.out.println(lockBank.getAccount());
        ArrayList<Thread> list = new ArrayList<>();
        for (int i =0;i<1000;i++){
            list.add(new Thread(new LockThread(lockBank)));
        }

        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println(lockBank.getAccount());

    }
}
