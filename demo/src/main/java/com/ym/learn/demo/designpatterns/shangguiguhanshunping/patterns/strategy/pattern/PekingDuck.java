package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.strategy.pattern;

public class PekingDuck extends Duck {
    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("北京鸭~~~");
    }
    //因为北京鸭不会飞翔，因此需要重写fly
}
