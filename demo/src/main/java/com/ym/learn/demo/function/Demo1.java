package com.ym.learn.demo.function;

import java.util.function.Function;

public class Demo1 {
    public static void main(String[] args) {
        Function function = new Function<Integer,String>() {
            @Override
            public String apply(Integer o) {
                return String.valueOf(o);
            }
        };

        Function function1 = (str) -> {return str;};

        System.out.println(((Function<Integer, String>) function).apply(4));
        System.out.println(function1.apply("123"));
    }
}
