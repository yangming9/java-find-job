package com.ym.learn.demo.designpatterns.kuangshen.proxy.quiet.demo2;

public class Client {
    public static void main(String[] args) {
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(new UserServiceImpl());
        proxy.add();
    }
}
