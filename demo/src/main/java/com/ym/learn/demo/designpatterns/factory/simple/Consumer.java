package com.ym.learn.demo.designpatterns.factory.simple;

public class Consumer {
    public static void main(String[] args) {

        Car car = new WuLing();
        Car car1 = new Tesla();

        car.name();
        car1.name();


        //2.使用工厂创建
        Car car2 = CarFactory.getCar("五菱");
        Car car3 = CarFactory.getCar("Tesla");
    }
}
