package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.visitor;

public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男  给待定");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女 给 待定");
    }
}
