package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.adapter.objectadapter;

//适配器类
public class Adapter implements IVoltage5 {

    private Voltage220 voltage220;

    public Adapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    public void setVoltage220(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int output5() {
        //获取到220
        int dstV = 0;
        if (null != voltage220) {
            int src = voltage220.output220();
            dstV = src/44;
        }
        return dstV;
    }
}
