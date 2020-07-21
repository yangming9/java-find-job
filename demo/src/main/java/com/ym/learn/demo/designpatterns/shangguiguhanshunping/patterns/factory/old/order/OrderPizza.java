package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.simplefactory.order;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.simplefactory.CheesePizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.simplefactory.GreekPizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.simplefactory.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;//订购pizza的类型
        do {
            orderType = gettype();
            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
            }else {
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    //写一个方法可以获取客户希望订购的pizza
    private String gettype(){
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }
}
