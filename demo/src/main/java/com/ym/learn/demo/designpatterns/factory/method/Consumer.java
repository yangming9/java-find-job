package com.ym.learn.demo.designpatterns.factory.method;

public class Consumer {
    public static void main(String[] args) {
        Car car = new TeslaFactory().getCar();
        Car car1 = new WulingFactory().getCar();
        Car car2 = new DaZhongFactory().getCar();
        System.out.println(car);
        car.name();
        System.out.println(car1);
        car1.name();
        System.out.println(car2);
        car2.name();
    }
}
