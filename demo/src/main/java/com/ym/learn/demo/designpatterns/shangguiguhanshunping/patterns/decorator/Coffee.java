package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.decorator;

public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
