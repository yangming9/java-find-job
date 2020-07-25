package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.prototype.deepclone;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype deepPrototype = new DeepPrototype();

        deepPrototype.name = "yangming";

        deepPrototype.deepCloneableTarget = new DeepCloneableTarget("daniu","daniulei");

        //方式1进行深拷贝

        DeepPrototype deepPrototype1 = (DeepPrototype) deepPrototype.clone();

        System.out.println("deepPrototype.name="+deepPrototype.name+"deepPrototype.deepCloneableTarget="+deepPrototype.deepCloneableTarget.hashCode());
        System.out.println("deepPrototype1.name="+deepPrototype1.name+"deepPrototype1.deepCloneableTarget="+deepPrototype1.deepCloneableTarget.hashCode());
        DeepPrototype deepPrototype2 = (DeepPrototype) deepPrototype.deepClone();
        System.out.println("deepPrototype2.name="+deepPrototype2.name+"deepPrototype2.deepCloneableTarget="+deepPrototype2.deepCloneableTarget.hashCode());
    }
}
