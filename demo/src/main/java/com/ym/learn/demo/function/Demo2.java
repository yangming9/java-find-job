package com.ym.learn.demo.function;

import java.util.function.Predicate;

public class Demo2 {
    public static void main(String[] args) {
        Predicate<String> predicate = (str) -> {return str.isEmpty();};
        System.out.println(predicate.test(""));
    }
}
