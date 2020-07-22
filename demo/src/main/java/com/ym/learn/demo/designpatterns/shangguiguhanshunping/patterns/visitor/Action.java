package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.visitor;

public abstract class Action {
    //得到男性 的评测
    public abstract void getManResult(Man man);

    //得到女性 的测评
    public abstract void getWomanResult(Woman woman);
}
