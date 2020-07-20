package com.ym.learn.demo.designpatterns.kuangshen.builder.demo;
//指挥  负责指挥构建一个工程 工程如何构建 由他决定  是 核心
public class Director {
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }
}
