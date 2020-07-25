package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.visitor;
//说明
//1.这里使用了 双分派  即 首先在客户端程序中  将具体状态作为参数传递到 Woman中
//然后Woman类调用为参数的具体方法中 方法getWomanResult 同时将自己this作为参数传入
//完成了第二次的分派
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
