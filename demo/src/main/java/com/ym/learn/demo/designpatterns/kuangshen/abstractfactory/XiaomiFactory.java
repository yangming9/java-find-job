package com.ym.learn.demo.designpatterns.kuangshen.abstractfactory;

public class XiaomiFactory implements IProductFactory {
    @Override
    public IphoneProduct phoneFactory() {
        return new XiaoMi();
    }

    @Override
    public IRouterProduct routerFactory() {
        return new XiaomiRouter();
    }
}
