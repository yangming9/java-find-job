package com.ym.learn.demo.multithread;

public class ThreadLocalBank {
    private static ThreadLocal<Integer> account = ThreadLocal.withInitial(() -> 0);
    public void save(int money){
        account.set(account.get()+money);
    }
    public int getAccount(){
        return account.get();
    }
}
