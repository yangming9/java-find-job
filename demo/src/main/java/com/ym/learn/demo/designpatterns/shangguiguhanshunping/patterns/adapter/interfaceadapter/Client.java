package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.adapter.interfaceadapter;

public class Client {
    public static void main(String[] args) {
        //使用匿名内部类的方式实现接口适配器
        AbsAdapter adapter = new AbsAdapter() {
            //只需要覆盖 需要使用的接口方法
            @Override
            public void m1() {
                System.out.println("使用了m1方法");
            }
        };

        adapter.m1();
    }
}
