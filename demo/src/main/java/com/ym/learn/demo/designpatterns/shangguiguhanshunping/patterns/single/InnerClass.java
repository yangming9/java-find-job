package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.single;

/**
 * 静态内部类的方式进行  推荐使用
 * 外部类装载  内部类不会立刻装载   调用getInstance方法才会被装载
 * 装载内部类的时候 jvm保证了其他线程不能进入  避免了线程的不安全
 * 提供懒加载   效率也高 推荐使用  但是无法防止反序列化和反射破解
 */
public class InnerClass {
    private InnerClass() {
    }

    private static class InnerClassHolder {
        private static final InnerClass INSTANCE = new InnerClass();
    }

    public static InnerClass getInstance() {
        return InnerClassHolder.INSTANCE;
    }
}
