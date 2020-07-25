package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.order;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.LDCheesePizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.LDPepperPizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.Pizza;

public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
