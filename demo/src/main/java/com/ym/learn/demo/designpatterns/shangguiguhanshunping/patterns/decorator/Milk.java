package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.decorator;

public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        setDes(" 牛奶");
        setPrice(2.0f);
    }
}
