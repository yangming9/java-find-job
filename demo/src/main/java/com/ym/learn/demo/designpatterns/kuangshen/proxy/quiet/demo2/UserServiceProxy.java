package com.ym.learn.demo.designpatterns.kuangshen.proxy.quiet.demo2;

public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public UserServiceProxy() {
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void get() {
        log("get");
        userService.get();
    }
    //日志方法
    private void log(String msg) {
        System.out.println("使用了" + msg + "方法");
    }
}
