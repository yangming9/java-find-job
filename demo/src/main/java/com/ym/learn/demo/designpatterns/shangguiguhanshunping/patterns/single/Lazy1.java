package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.single;

/**
 * 懒汉式  第二种  线程安全懒汉式 加入synchronized  锁机制
 * 实际开发中不推荐使用此种方式   方法进行同步 效率太低
 */
public class Lazy1 {
    private Lazy1() {
    }

    private static Lazy1 INSTANCE;

    public synchronized static Lazy1 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Lazy1();
        }
        return INSTANCE;
    }

}
class Main2{
    public static void main(String[] args) {
        for (int i = 0;i<100;i++){
            new Thread(() -> {
                Lazy1 instance = Lazy1.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}