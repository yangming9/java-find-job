package com.ym.learn.demo.designpatterns.builder.demo1;
//建造者  静态内部类返回当前对象
public abstract class Builder {
    abstract Builder buildA(String msg);//汉堡
    abstract Builder buildB(String msg);//可乐
    abstract Builder buildC(String msg);//薯条
    abstract Builder buildD(String msg);//甜品

    abstract Product getProduct();
}
