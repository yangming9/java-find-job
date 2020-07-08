package com.ym.learn.demo.designpatterns.proxy.lively.demo1;

public class Host implements Rent {

    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
