package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.single;

/**
 * 枚举的方式
 * 防止了反序列化 和反射进行破坏
 * 因为单例是没有构造函数的
 */
public enum EnumClass {
    INSTANCE;

    public void method() {
        System.out.println("枚举的方式提供单例模式");
    }

}
