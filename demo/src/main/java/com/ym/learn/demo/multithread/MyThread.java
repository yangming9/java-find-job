package com.ym.learn.demo.multithread;

public class MyThread implements Runnable{

    private Bank bank;

    public MyThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.save(1);
    }
}
