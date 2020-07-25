package com.ym.learn.demo.designpatterns.kuangshen.single;
//饿汉式单例  可能会浪费空间，实例创建就申请了空间，但是可能并没有使用就会造成空间的浪费
public class Hungry {

    private byte[] bytes = new byte[1024*1024];
    private byte[] bytes1 = new byte[1024*1024];
    private byte[] bytes2 = new byte[1024*1024];
    private byte[] bytes3 = new byte[1024*1024];

    private Hungry() {
    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
