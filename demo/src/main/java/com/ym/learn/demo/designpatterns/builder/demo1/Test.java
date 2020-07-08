package com.ym.learn.demo.designpatterns.builder.demo1;

public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Product product = worker.buildA("全家桶").buildB("雪碧")
                .getProduct();
        System.out.println(product.toString());
    }
}
