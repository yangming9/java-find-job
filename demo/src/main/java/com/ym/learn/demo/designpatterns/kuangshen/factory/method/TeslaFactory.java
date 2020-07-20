package com.ym.learn.demo.designpatterns.kuangshen.factory.method;

public class TeslaFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
