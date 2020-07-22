package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.visitor;

public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
