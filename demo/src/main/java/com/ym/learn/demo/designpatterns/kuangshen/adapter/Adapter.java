package com.ym.learn.demo.designpatterns.kuangshen.adapter;
//1.继承（类适配器 单继承）
//2.组合（对象适配器： 常用）


//真正的适配器
public class Adapter extends Adaptee implements NetToUSB{
    @Override
    public void handleRequest() {
        super.request();
    }
}
