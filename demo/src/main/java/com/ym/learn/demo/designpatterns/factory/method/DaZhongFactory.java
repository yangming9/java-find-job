package com.ym.learn.demo.designpatterns.factory.method;

public class DaZhongFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Dazhong();
    }
}
