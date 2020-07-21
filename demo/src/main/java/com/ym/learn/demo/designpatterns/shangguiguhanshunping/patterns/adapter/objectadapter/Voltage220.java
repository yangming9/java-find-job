package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.adapter.objectadapter;
//被适配的类  220V电压
public class Voltage220 {
    public int output220(){
        int src = 220;
        System.out.println("电压="+src+"V");
        return src;
    }
}
