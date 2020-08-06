package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.strategy.pattern;

public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞行技术不好");
    }
}
