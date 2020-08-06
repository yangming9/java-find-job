package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.strategy.pattern;

public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("擅长飞行");
    }
}
