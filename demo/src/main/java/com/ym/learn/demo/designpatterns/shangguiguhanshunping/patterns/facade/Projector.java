package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.facade;

public class Projector {
    private Projector() {
    }
    private static final Projector instance = new Projector();

    public static Projector getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("projector on");
    }

    public void off(){
        System.out.println("projector off");
    }

    public void focus(){
        System.out.println("projector focus");
    }
}
