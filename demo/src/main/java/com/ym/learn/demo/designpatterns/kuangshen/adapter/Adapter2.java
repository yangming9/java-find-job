package com.ym.learn.demo.designpatterns.kuangshen.adapter;
//热插拔式
public class Adapter2 implements NetToUSB {

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }
}
