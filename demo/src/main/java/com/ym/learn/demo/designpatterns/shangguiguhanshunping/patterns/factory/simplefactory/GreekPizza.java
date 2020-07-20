package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.simplefactory;

public class GreekPizza extends Pizza {

    public GreekPizza() {
        super.name = "greek";
    }

    @Override
    public void prepare() {
        System.out.println("给制作greek pizza 准备原材料");
    }
}
