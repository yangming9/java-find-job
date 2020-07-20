package com.ym.learn.demo.designpatterns.shangguiguhanshunping.yuanze;
/**
 * 单一原则
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");

    }
}

//方案2分析
//1.遵守了单一职责原则
//2.这样做花销很大，即将类分解，同时修改客户端
//3.改进：直接修改Vehicle类，改动的代码会比较少=>方案三
class RoadVehicle {
    public void run(String vehicle){
        System.out.println(vehicle+"公路运行");
    }
}

class AirVehicle {
    public void run(String vehicle){
        System.out.println(vehicle+"天空运行");
    }
}

class WaterVehicle {
    public void run(String vehicle){
        System.out.println(vehicle+"水上运行");
    }
}
