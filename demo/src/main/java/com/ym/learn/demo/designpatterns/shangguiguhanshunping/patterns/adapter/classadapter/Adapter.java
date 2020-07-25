package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.adapter.classadapter;
//适配器类
public class Adapter extends Voltage220 implements IVoltage5{

    @Override
    public int output5() {
        //获取到220
        int src = output220();
        int dstV = src/44;
        return dstV;
    }
}
