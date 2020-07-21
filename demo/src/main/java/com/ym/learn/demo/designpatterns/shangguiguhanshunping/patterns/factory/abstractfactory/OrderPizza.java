package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.order.ABSFactory;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    ABSFactory absFactory;

    public OrderPizza(ABSFactory absFactory) {
        setAbsFactory(absFactory);
    }

    private void setAbsFactory(ABSFactory absFactory) {
        Pizza pizza = null;
        String orderType = "";
        this.absFactory = absFactory;
        do {
            orderType = gettype();
            pizza = absFactory.createPizza(orderType);

            if (pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购失败");
                break;
            }
        }while (true);
    }

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
