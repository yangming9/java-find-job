package com.ym.learn.demo;

/**
 * 测试final定义的变量的值能否在构造函数中进行重新赋值
 * 结论
 * 如果final修饰的变量已经在声明成员变量的时候进行了初始化，那么构造函数是不能重新赋初值的
 * 如果final修饰的变量没有进行初始化，那么对象的构造函数可以对其进行赋初值，但是不可以重新赋值
 */
public class TestFinalVal {

    public final Integer val2 = 2;

    public final Integer val;

    public TestFinalVal(Integer val) {
        this.val = val;
    }

}
