package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.order;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza.LDCheesePizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza.LDPepperPizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza.Pizza;

public class LDFactory implements ABSFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用伦敦工厂模式");
        if (orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }

        return pizza;
    }
}
