package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.observe.observe1;

public class CurrentConditions {
    private float temperature;//温度
    private float pressure;//气压
    private float humidity;//湿度

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("***today temperature:"+temperature);
        System.out.println("***today pressure:"+pressure);
        System.out.println("***today humidity:"+humidity);
    }
}
