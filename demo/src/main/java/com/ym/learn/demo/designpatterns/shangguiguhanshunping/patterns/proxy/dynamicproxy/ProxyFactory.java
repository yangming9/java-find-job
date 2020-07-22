package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    //维护一个目标对象
    private Object target;

    //构建构造器时 对target进行初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象 生成一代理对象
    public Object getProxyInstance(){
        /**
         * 说明
         * 1.classloader 指定当前目标对象使用的类加载器，获取加载器的方法是固定的
         * 2.interfaces 目标对象实现的接口类型，使用泛型的方式确认类型
         * 3.Invocationhandler  事件处理，执行目标对象的方法时会去触发事件处理器的方法  会把当前执行的目标对象方法作为一个参数传入
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("代理开始");
                //反射机制调用目标对象的方法
                Object invoke = method.invoke(target, args);
                return invoke;
            }
        });
    }

}
