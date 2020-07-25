package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.facade;

public class Stereo {
    private Stereo() {
    }

    private static final Stereo instance = new Stereo();

    public static Stereo getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("Stereo on");
    }

    public void off(){
        System.out.println("Stereo off");
    }

    public void up() {
        System.out.println("Stereo up");
    }
}
