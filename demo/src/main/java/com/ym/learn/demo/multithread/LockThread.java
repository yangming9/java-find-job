package com.ym.learn.demo.multithread;

public class LockThread implements Runnable{
    private LockBank lockBank;

    public LockThread(LockBank lockBank) {
        this.lockBank = lockBank;
    }

    @Override
    public void run() {
        lockBank.save(1);
    }
}
