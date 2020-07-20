package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.single;

/**
 * 懒汉式  同步代码块式  线程不安全   不能使用
 */
public class Lazy2 {
    private Lazy2() {
    }
    private static Lazy2 INSTANCE;

    public static Lazy2 getInstance(){
        if (INSTANCE==null){//多个线程进入这个代码  后面会从创建不同的对象
            synchronized (Lazy2.class){
                INSTANCE = new Lazy2();
            }
        }
        return INSTANCE;
    }
}
