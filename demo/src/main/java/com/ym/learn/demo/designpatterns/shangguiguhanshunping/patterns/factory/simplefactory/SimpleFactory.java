package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.simplefactory;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.old.CheesePizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.old.GreekPizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.old.Pizza;

//简繁工厂类
public class SimpleFactory {

//    根据orderType返回一个Pizza实例
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;

        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
        }

        return pizza;
    }
}
