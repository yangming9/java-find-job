package com.ym.learn.demo.designpatterns.proxy.lively.demo2;

import com.ym.learn.demo.designpatterns.proxy.quiet.demo2.UserService;
import com.ym.learn.demo.designpatterns.proxy.quiet.demo2.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserService userService = new UserServiceImpl();
        CommonProxyInvocationHandler commonProxyInvocationHandler = new CommonProxyInvocationHandler();
        commonProxyInvocationHandler.setTarget(userService);
        UserService proxy = (UserService) commonProxyInvocationHandler.getProxy();
        proxy.add();
    }
}
