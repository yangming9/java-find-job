package com.ym.learn.demo.test;

import java.util.concurrent.atomic.AtomicReference;

public class SimpleObject {
    private String name;
    private Integer age;

    private SimpleObject(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        SimpleObject test = new SimpleObject("test3" , 30);
        AtomicReference<SimpleObject> atomicReference2 = new AtomicReference<>();
        Boolean bool = atomicReference2.compareAndSet(test, new SimpleObject("test4", 40));
        System.out.println("simpleObject  Value: " + bool);
    }
}
