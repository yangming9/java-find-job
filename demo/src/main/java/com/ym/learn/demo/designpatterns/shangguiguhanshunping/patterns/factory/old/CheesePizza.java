package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.old;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        super.name = "cheese";
    }

    @Override
    public void prepare() {
        System.out.println("给制作奶酪pizza准备原材料");
    }
}
