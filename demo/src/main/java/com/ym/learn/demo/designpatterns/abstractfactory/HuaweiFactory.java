package com.ym.learn.demo.designpatterns.abstractfactory;

public class HuaweiFactory implements IProductFactory {
    @Override
    public IphoneProduct phoneFactory() {
        return new Huawei();
    }

    @Override
    public IRouterProduct routerFactory() {
        return new HuaweiRouter();
    }
}
