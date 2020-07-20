package com.ym.learn.demo.designpatterns.shangguiguhanshunping.yuanze;
/**
 * 单一原则
 */
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("摩托车");
        vehicle2.run("汽车");
        vehicle2.runAir("飞机");
        vehicle2.runWater("轮船");
    }
}

//交通工具类
//方式3分析
//1.这种修改方法没有对原来的类做大的修改，只是增加了方法
//2.这种虽然没有在类的这个级别上遵守单一职责，但是在方法级别上遵循了单一原则
class Vehicle2{
    public void run(String vehicle){
        System.out.println(vehicle+"在公路上运行....");
    }

    public void runAir(String vehicle){
        System.out.println(vehicle+"在天上运行....");
    }

    public void runWater(String vehicle){
        System.out.println(vehicle+"在水上运行....");
    }
}
