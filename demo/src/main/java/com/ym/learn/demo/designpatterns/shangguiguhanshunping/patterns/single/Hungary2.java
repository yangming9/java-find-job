package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.single;

/**
 * 静态代码块式饿汉式
 */
public class Hungary2 {
    private Hungary2() {
    }

    private static Hungary2 INSTANCE;

    static {//静态代码块只执行一次
        INSTANCE = new Hungary2();
    }

    public static Hungary2 getInstance() {
        return INSTANCE;
    }

}
