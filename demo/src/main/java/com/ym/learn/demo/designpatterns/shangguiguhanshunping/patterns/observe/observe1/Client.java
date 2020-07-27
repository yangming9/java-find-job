package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.observe.observe1;

/**
 * 传统方案  这里并不是真的观察者模式
 */
public class Client {

    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(30,150,40);
        weatherData.setData(40,160,80);
    }
}
