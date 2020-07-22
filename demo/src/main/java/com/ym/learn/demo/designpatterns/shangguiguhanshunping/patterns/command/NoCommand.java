package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.command;

/**
 * 用于初始化按钮  没有任何命令 空执行
 * 当调用空命令，对象什么都不做即可
 * 好处：其实这也是一种设计模式，可以省掉对空的判断
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
