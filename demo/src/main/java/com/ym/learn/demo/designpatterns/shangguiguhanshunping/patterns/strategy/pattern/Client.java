package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.strategy.pattern;

/**
 * 策略模式  真正的设计模式
 */
public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.display();
        wildDuck.fly();
        ToyDuck toyDuck = new ToyDuck();
        toyDuck.display();
        toyDuck.fly();
        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        pekingDuck.setQuackBehavior(new GAGAQuackBehavior());
        pekingDuck.display();
        pekingDuck.fly();
        pekingDuck.quack();
    }
}
