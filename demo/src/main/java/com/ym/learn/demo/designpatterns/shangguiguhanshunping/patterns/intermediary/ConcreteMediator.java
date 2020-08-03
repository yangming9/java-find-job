package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.intermediary;

import java.util.HashMap;

public class ConcreteMediator extends Mediator {

    private HashMap<String,Colleague> colleagueHashMap;
    private HashMap<String,String> interMap;

    public ConcreteMediator() {
        colleagueHashMap = new HashMap<String,Colleague>();
        interMap = new HashMap<String,String>();
    }

    @Override
    public void Register(String colleagueName, Colleague colleague) {
        colleagueHashMap.put(colleagueName,colleague);
        if (colleague instanceof Alarm){
            interMap.put("Alarm",colleagueName);
        }
    }

    //具体中介者的核心方法
    //1.根据得到的消息 完成对应任务
    //2.中介者在这个方法，协调各个具体的同事对象，完成任务
    @Override
    public void getMessage(int stateChange, String colleagueName) {

    }

    @Override
    public void SendMessage() {

    }
}
