package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.order;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.abstractfactory.pizza.Pizza;

//一个抽象工厂模式的抽象层（接口）
public interface ABSFactory {
    Pizza createPizza(String orderType);
}
