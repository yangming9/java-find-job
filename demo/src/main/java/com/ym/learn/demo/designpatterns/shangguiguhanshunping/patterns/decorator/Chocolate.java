package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.decorator;
//具体的调味品 具体的Decorator
public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        setDes(" chocolate");
        setPrice(3.0f);
    }


}
