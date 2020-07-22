package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.command;

//创建命令接口
public interface Command {
    //执行动作
    void execute();

    //撤销命令
    void undo();
}
