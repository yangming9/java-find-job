package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.builder;

public class Client {
    public static void main(String[] args) {
        //盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        //准备创建房子指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        //完成盖房子，返回产品
        houseDirector.constructHouse();

        HighBuilding highBuilding = new HighBuilding();

        houseDirector.setHouseBuilder(highBuilding);

        houseDirector.constructHouse();


        StringBuilder stringBuilder = new StringBuilder("qweqrr");
        System.out.println(stringBuilder);

    }
}
