package com.ym.learn.demo.designpatterns.kuangshen.factory.simple;

/**
 * 简单工厂(静态工厂模式)
 */
public class CarFactory {
    public static Car getCar(String car){
        if (car.equals("五菱")){
            return new WuLing();
        }
        else if (car.equals("Tesla")){
            return new Tesla();
        }else if (car.equals("大众")){
          return new Dazhong();
        } else {
            return null;
        }
    }
}
