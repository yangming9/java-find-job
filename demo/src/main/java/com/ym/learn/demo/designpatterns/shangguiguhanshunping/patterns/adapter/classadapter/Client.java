package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.adapter.classadapter;

public class Client {
    public static void main(String[] args) {
        System.out.println("类适配器模式");
        Phone phone = new Phone();
        phone.charging(new Adapter());
    }
}
