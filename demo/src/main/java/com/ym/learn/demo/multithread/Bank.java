package com.ym.learn.demo.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * synchronized方法，在方法的声明前加入synchronized关键字  例如本类
 */
public class Bank {
//    private int account = 0;
    //使用原子变量的方式
    private AtomicInteger account = new AtomicInteger(0);

    public int getAccount() {
        return account.get();
    }

    //同步方法写法1
//    public synchronized void save(int money) {
//        this.account += money;
//    }

    //同步方法由于加锁范围过大，效率会严重影响，此时其实使用同步代码块即可
    //修改为一下的方式即可
//    public void save(int money) {
//        synchronized(this) {
//            this.account += money;
//        }
//    }

    //使用原子变量进行操作
    public void save(int money){
        account.addAndGet(money);
    }
}
