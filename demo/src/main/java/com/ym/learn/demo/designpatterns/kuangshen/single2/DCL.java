package com.ym.learn.demo.designpatterns.kuangshen.single2;

public class DCL {
    private DCL() {
    }
    private static volatile DCL INSTANCE;//禁止指令重排序，防止多线程在访问的时候访问到未初始化的对象出现问题

    public static DCL getInstance(){
        if (INSTANCE == null){
            synchronized (DCL.class){
                if (INSTANCE == null){
                    INSTANCE = new DCL();//这里极端情况下会有指令重排序的问题。
                }
            }
        }

        return INSTANCE;
    }
}
