package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.prototype;

public class Client {

    public static void main(String[] args) {
        //传统方法解决
        Sheep sheep = new Sheep("tom", 1, "white");

        Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep2= new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep3 =new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep4 =new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep5 =new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());

        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);




    }
}
