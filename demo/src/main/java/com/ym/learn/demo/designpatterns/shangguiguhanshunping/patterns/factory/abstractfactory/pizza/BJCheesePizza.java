package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪pizza");
        System.out.println("给北京的奶酪pizza准备原材料");
    }
}
