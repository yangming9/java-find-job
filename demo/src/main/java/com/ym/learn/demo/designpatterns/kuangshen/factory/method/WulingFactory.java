package com.ym.learn.demo.designpatterns.kuangshen.factory.method;

public class WulingFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new WuLing();
    }
}
