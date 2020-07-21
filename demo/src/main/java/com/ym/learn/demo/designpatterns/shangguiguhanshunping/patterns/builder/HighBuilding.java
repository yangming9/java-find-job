package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.builder;

public class HighBuilding extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("楼房打地基100m");
    }

    @Override
    public void buildWalls() {
        System.out.println("楼房砌墙20cm");
    }

    @Override
    public void roofed() {
        System.out.println("楼房封顶");
    }
}
