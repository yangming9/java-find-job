package com.ym.learn.demo.designpatterns.factory.method;

public class TeslaFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
