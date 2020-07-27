package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.observe.observe2;

/**
 * 观察者模式  这里是真正的观察者模式
 * 观察者模式是多对一的依赖的一种设计方案，被依赖的对象为subject 依赖的对象为Observer
 * subject通知Observer变化，比如这里的奶站是Subject，是1的一方
 * 用户是Observer 是多的一方
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditions currentConditions = new CurrentConditions();

        weatherData.registerObserver(currentConditions);

        weatherData.setData(10,200,30);
    }
}
