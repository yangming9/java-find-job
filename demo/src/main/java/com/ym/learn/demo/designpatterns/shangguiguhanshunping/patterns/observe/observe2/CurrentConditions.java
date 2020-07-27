package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.observe.observe2;

public class CurrentConditions implements Observer{
    private float temperature;//温度
    private float pressure;//气压
    private float humidity;//湿度

    @Override
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
