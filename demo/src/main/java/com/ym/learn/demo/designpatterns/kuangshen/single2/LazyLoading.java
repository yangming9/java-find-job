package com.ym.learn.demo.designpatterns.kuangshen.single2;

public class LazyLoading {

    private LazyLoading() {
    }

    private static LazyLoading INSTANCE;

    public void m(){
        System.out.println("m");
    }

    public static LazyLoading getInstance(){
        if (INSTANCE == null){//多线程时候，第一个线程执行到现在，另外一个线程也执行到这里，那么会出现两个对象
            INSTANCE = new LazyLoading();
        }
        return INSTANCE;
    }
}
