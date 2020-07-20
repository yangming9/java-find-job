package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.single;

/**
 * 懒汉式 多线程不安全  实际开发中不能使用
 */
public class Lazy {
    private Lazy() {
    }

    private static Lazy INSTANCE;

    public static Lazy getInstance() {
        if (INSTANCE == null){
            INSTANCE = new Lazy();
        }
        return INSTANCE;
    }
}
class Main{
    public static void main(String[] args) {
        for (int i = 0;i<100;i++){
            new Thread(() -> {
                Lazy instance = Lazy.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}