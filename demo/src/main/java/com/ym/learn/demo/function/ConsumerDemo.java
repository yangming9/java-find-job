package com.ym.learn.demo.function;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer consumer = (str) -> {
            System.out.println(str);
        };
        consumer.accept("adsalmalds");
    }
}
