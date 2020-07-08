package com.ym.learn.demo.designpatterns.proxy.lively.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口

    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxy(){
       return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);//固定只需要更改rent就可以了
    }


    //处理代理实例,并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        动态代理的本质就是使用反射机制实现
        Object result = method.invoke(rent, args);

        return result;
    }
}
