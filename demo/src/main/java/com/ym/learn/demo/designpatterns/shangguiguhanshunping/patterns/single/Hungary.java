package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.single;

/**
 * 静态常量式饿汉式
 * 优点：
 * 写法简单，在类装载的时候就完成了实例化，避免了线程同步问题
 * 缺点：
 * 在类装载的时候就完成实例化，没有达到懒加载的效果。如果从开始到最后没有使用这个实例。则会造成内存浪费
 * 这种方式基于classloader机制避免了多线程的同步问题。
 */
public class Hungary {

    private Hungary() {

    }

    private static final Hungary INSTANCE = new Hungary();

    public static Hungary getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Hungary instance = Hungary.getInstance();
        Hungary instance1 = Hungary.getInstance();
        System.out.println(instance == instance1);
    }
}
