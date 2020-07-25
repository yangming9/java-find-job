package com.ym.learn.demo.designpatterns.shangguiguhanshunping.yuanze;

/**
 * 单一原则
 */
public class SingleResponsibility {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}
//交通工具类
//方式1
//1.方式1的run方法中违反了单一职责原则
//2.解决的方案非常的简单，根据交通工具的运行方法不同，分解成不同的类即可
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在公路上运行....");
    }
}
