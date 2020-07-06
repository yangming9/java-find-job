package com.ym.learn.demo.threadpool;

import java.util.concurrent.TimeUnit;

public class ThreadLocal2 {
    //将ThreadLocal想象成一个容器，容器里面可以装对象 装的是 M
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(tl.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            tl.set(new Person());
            System.out.println(tl.get());
        }).start();

    }

    static class Person{
        String name = "zhangsan";
    }

}
