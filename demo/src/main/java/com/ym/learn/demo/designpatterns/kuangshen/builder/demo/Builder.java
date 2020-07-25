package com.ym.learn.demo.designpatterns.kuangshen.builder.demo;

//抽象的建造者：方法
public abstract class Builder {

    abstract void buildA();

    abstract void buildB();

    abstract void buildC();

    abstract void buildD();

    //完工
    abstract Product getProduct();
}
