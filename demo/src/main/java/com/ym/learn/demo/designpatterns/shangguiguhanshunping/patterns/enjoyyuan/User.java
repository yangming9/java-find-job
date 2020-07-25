package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.enjoyyuan;
//享元模式中的外部状态
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
