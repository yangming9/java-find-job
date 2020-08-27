package com.ym.learn.demo.multithread;

public class BaseTest {
    //可以继承父类即父线程中ThreadLocal变量
    public static final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        inheritableThreadLocal.set("inheritable hello");
        threadLocal.set("hello");
        new Thread(() -> {
            System.out.println(String.format("子线程可继承值： %s",inheritableThreadLocal.get()));
            System.out.println(String.format("子线程值："+threadLocal.get()));
            new Thread(() -> {
                System.out.println(String.format("孙子线程可继承值： %s",inheritableThreadLocal.get()));
                System.out.println(String.format("孙子线程值："+threadLocal.get()));
            }).start();
        }).start();
        System.out.println("主线程值："+threadLocal.get());
    }

}
