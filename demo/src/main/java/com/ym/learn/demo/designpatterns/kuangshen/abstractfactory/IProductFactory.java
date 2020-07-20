package com.ym.learn.demo.designpatterns.kuangshen.abstractfactory;

public interface IProductFactory {
    //生产手机
    IphoneProduct phoneFactory();
    //生产路由器
    IRouterProduct routerFactory();
}
