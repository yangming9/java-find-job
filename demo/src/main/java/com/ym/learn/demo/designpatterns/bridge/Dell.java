package com.ym.learn.demo.designpatterns.bridge;

public class Dell implements Brand {
    @Override
    public void info() {
        System.out.println("dell");
    }
}
