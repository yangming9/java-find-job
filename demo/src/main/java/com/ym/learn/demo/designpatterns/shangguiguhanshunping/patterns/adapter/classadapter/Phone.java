package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.adapter.classadapter;

public class Phone {
    //充电方法
    public void charging(IVoltage5 iVoltage5){
        if (iVoltage5.output5() == 5){
            System.out.println("电压为5V，可以充电了~~~");
        }else if (iVoltage5.output5()>5){
            System.out.println("电压过大无法充电");
        }
    }
}
