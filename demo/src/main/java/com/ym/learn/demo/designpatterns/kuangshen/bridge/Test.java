package com.ym.learn.demo.designpatterns.kuangshen.bridge;

public class Test {

    public static void main(String[] args) {
        Computer computer = new Laptop(new Apple());
        computer.info();

        Computer computer1 = new Destop(new Dell());
        computer1.info();
    }
}
