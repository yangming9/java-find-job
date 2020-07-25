package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.builder;
//对应角色 ： 抽象的建造者
public abstract class HouseBuilder {
    protected House house = new House();

    //将建造的流程写好
    //打地基
    public abstract void buildBasic();

    //砌墙
    public abstract void buildWalls();

    //封顶
    public abstract void roofed();

    //建造好房子将产品返回
    public House buildHouse() {
        return house;
    }
}
