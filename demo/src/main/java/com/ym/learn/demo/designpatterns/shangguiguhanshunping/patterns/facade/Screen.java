package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.facade;

public class Screen {
    private Screen() {
    }
    private static final Screen instance = new Screen();

    public static Screen getInstance(){
        return instance;
    }

    public void up(){
        System.out.println("Screen up");
    }

    public void down(){
        System.out.println("Screen down");
    }
}
