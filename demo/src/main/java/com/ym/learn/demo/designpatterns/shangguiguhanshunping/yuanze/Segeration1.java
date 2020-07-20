package com.ym.learn.demo.designpatterns.shangguiguhanshunping.yuanze;

/**
 * 接口隔离原则
 * A 只用到了 B中的三个方法
 * C 用到了B中的三个方法
 * 这就违背了 接口隔离原则
 * 因此需要将接口Interface1进行拆分
 */
public class Segeration1 {
    public static void main(String[] args) {

    }
}
interface Inteface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}

class B implements Inteface1{

    @Override
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B 实现了 operation5");
    }
}
class A {
    public void depend1(Inteface1 inteface1){
        inteface1.operation1();
    }

    public void depend2(Inteface1 inteface1){
        inteface1.operation2();
    }

    public void depend3(Inteface1 inteface1){
        inteface1.operation3();
    }
}

class C {
    public void depend1(Inteface1 inteface1){
        inteface1.operation1();
    }

    public void depend4(Inteface1 inteface1){
        inteface1.operation4();
    }

    public void depend5(Inteface1 inteface1){
        inteface1.operation5();
    }
}