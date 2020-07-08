package com.ym.learn.demo.designpatterns.builder.demo;
//建造者
public class Worker extends Builder {

    private Product product;

    public Worker() {
        product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildB("地B基");
        System.out.println("地基");
    }

    @Override
    void buildB() {
        product.setBuildC("钢筋工程");
        System.out.println("钢筋工程");
    }

    @Override
    void buildC() {
        product.setBuildD("铺电线");
        System.out.println("铺电线");
    }

    @Override
    void buildD() {
        product.setBuildA("粉刷墙面");
        System.out.println("粉刷墙面");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
