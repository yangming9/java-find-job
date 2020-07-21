package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.decorator;

public class Soy extends Decorator {
    public Soy(Drink drink) {
        super(drink);
        setDes(" soy");
        setPrice(1.0f);
    }
}
