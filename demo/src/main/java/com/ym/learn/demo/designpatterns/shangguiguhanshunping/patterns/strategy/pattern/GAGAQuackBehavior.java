package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.strategy.pattern;

public class GAGAQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("鸭子 嘎嘎嘎");
    }
}
