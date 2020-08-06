package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.strategy.pattern;

public class WildDuck extends Duck {
    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是野鸭~");
    }
}
