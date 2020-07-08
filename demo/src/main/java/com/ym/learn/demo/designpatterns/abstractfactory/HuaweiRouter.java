package com.ym.learn.demo.designpatterns.abstractfactory;

public class HuaweiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("启动华为理由器");
    }

    @Override
    public void shutdown() {
        System.out.println("华为理由器关机");
    }

    @Override
    public void openWifi() {
        System.out.println("华为理由器开启wifi");
    }

    @Override
    public void setting() {
        System.out.println("华为理由器设置");
    }
}
