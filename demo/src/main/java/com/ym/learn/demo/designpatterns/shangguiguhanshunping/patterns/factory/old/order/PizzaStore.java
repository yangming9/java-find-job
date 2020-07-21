package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.old.order;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.simplefactory.SimpleFactory;

/**
 * 相当于一个客户端  发起订购任务
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
    }
}
