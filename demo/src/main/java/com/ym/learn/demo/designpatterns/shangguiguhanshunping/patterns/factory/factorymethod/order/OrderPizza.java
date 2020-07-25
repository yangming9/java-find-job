package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.order;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class OrderPizza {
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = gettype();
            pizza = createPizza(orderType);//工厂子类完成
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }

    //定义一个抽象方法，让各个工厂子类自己实现 createPizza
    abstract Pizza createPizza(String orderType);

    //写一个方法可以获取客户希望订购的pizza
    private String gettype() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
