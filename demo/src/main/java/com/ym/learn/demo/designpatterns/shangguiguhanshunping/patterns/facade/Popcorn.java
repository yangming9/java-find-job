package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.facade;

public class Popcorn {
    private Popcorn() {
    }

    private static final Popcorn instance = new Popcorn();

    public static Popcorn getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("popcorn on");
    }

    public void off(){
        System.out.println("popcorn off");
    }

    public void pop() {
        System.out.println("popcorn pop");
    }
}
