package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.intermediary;

public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        //对象创建时候，将自己放入 ConcreteMediator对象中【集合】
        mediator.Register(name,this);
    }

    public void SendAlarm(int stateChange){
        SendMessage(stateChange);
    }

    @Override
    public void SendMessage(int stateChange) {
        //调用中介对象的message
        this.getMediator().getMessage(stateChange,this.name);
    }
}
