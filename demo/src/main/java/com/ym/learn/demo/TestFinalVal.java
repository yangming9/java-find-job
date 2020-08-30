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

    /**
     * 关于函数的重载
     * 返回类型可以相同也可以不同  但是参数列表必须进行修改，否则不构成函数的重载
     * 参数列表可以是  参数顺序不同  参数类型不同  参数个数不同
     * @return
     */
    public int test(){
        return 0;
    }

    public int test(Integer a,String s){
        return 0;
    }

    public int test(String s,Integer a){
        return  0;
    }

    public int test(String a,String s){
        return 0;
    }

}
