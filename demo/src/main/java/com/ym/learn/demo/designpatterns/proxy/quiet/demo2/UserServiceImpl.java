package com.ym.learn.demo.designpatterns.proxy.quiet.demo2;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增加用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }

    @Override
    public void get() {
        System.out.println("查看用户");
    }
}
