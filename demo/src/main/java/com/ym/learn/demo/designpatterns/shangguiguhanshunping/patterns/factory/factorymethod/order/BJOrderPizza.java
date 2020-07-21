package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.order;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.BJCheesePizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.BJPepperPizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod.Pizza;

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
