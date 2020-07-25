package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.order;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza.BJCheesePizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza.BJPepperPizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza.Pizza;

public class BJFactory implements ABSFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用北京抽象工厂模式");
        if (orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }

        return pizza;
    }
}
