package com.ym.learn.demo.designpatterns.kuangshen.factory.method;

public class DaZhongFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Dazhong();
    }
}
