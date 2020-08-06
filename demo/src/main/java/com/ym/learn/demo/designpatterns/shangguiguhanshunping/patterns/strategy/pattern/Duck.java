package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.strategy.pattern;

public abstract class Duck {
    //属性，策略接口
    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void quack(){
        if (quackBehavior != null){
            quackBehavior.quack();
        }
    }

    public void swim(){
        System.out.println("鸭子会游泳~~~");
    }

    public void fly(){
        if (flyBehavior != null){
            flyBehavior.fly();
        }
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
