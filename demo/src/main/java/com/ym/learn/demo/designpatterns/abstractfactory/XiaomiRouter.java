package com.ym.learn.demo.designpatterns.abstractfactory;

public class XiaomiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("启动小米理由器");
    }

    @Override
    public void shutdown() {
        System.out.println("小米理由器关机");
    }

    @Override
    public void openWifi() {
        System.out.println("小米理由器开启wifi");
    }

    @Override
    public void setting() {
        System.out.println("小米理由器设置");
    }
}
