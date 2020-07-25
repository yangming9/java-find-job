package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒pizza");
        System.out.println("给伦敦的胡椒pizza准备原材料");
    }
}
