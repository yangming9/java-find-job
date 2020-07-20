package com.ym.learn.demo.designpatterns.kuangshen.single2;

/**
 * 静态内部类方式
 */
public class StaticInnerClass {
    private StaticInnerClass() {
    }
    private static class StaticClassHolder{
        private static final StaticInnerClass INSTANCE = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance(){
        return StaticClassHolder.INSTANCE;
    }
}
