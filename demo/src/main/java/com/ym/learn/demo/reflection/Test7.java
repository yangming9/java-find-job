package com.ym.learn.demo.reflection;

public class Test7 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取系统类加载器的父类加载器-》扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器 -》根加载器（C/C++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类哪个类加载器加载的
        ClassLoader classLoader = Class.forName("com.ym.learn.demo.reflection.Test7").getClassLoader();
        System.out.println(classLoader);

        classLoader = Class.forName("java.lang.Override").getClassLoader();
        System.out.println(classLoader);

        System.out.println(System.getProperty("java.class.path"));


    }
}
