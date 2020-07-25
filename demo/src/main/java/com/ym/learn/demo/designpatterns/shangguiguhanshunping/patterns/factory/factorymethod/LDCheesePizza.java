package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.factorymethod;

public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪pizza");
        System.out.println("给北京的伦敦pizza准备原材料");
    }
}
