package com.ym.learn.demo.designpatterns.kuangshen.adapter;

//客户端
public class Computer {
    public void net(NetToUSB netToUSB) {
        netToUSB.handleRequest();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter();
        Adapter2 adapter2 = new Adapter2(adaptee);
        computer.net(adapter);
        computer.net(adapter2);
    }
}
