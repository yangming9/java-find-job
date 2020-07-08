package com.ym.learn.demo.designpatterns.abstractfactory;

public class Client {
    public static void main(String[] args) {
        System.out.println("+++++++小米系列+++++++++");
//        小米工厂
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IphoneProduct iphoneProduct = xiaomiFactory.phoneFactory();
        iphoneProduct.start();
        iphoneProduct.sendSMS();
        iphoneProduct.shutdown();
        System.out.println("+++++++华为系列+++++++++");
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        IphoneProduct iphoneProduct1 = huaweiFactory.phoneFactory();
        iphoneProduct1.start();
        iphoneProduct1.sendSMS();
        iphoneProduct1.shutdown();
    }
}
