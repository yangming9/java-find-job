package com.ym.learn.demo.designpatterns.kuangshen.single2;

public class Hungary {
    private static final Hungary INSTANCE = new Hungary();
    private Hungary() {
    }
    public static Hungary getInstance(){
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }
}
