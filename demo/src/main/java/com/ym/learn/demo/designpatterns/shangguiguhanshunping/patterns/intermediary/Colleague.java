package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.intermediary;
//同事抽象类
public abstract class Colleague {
    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void SendMessage(int stateChange);
}
