package com.ym.learn.demo.designpatterns.bridge;

public abstract class Computer {
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void info(){
        brand.info();
    }
}

class Destop extends Computer{

    public Destop(Brand brand) {
        super(brand);
    }

    @Override
    public void info(){
        super.info();
        System.out.println("台式机");
    }
}
class Laptop extends Computer{

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void info(){
        super.info();
        System.out.println("笔记本");
    }
}