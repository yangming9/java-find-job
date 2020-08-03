package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.intermediary;

public abstract class Mediator {
    //将中介者对象 加入到集合中
    public abstract void Register(String colleagueName, Colleague colleague);

    //接收消息，具体的同事对象发出的
    public abstract void getMessage(int stateChange, String colleagueName);

    public abstract void SendMessage();
}
