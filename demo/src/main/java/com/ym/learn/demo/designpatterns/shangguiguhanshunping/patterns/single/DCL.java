package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.single;

/**
 * 双重检查式   推荐使用
 * 这个不会有线程安全  但是可以通过反射的方式进行破解
 * 加入双重检查锁的方法  解决了 延迟加载的问题  还提高了效率
 */
public class DCL {
    private DCL() {
    }
    private static volatile DCL INSTANCE;

    public static DCL getInstance() {
        if (INSTANCE == null) {
            synchronized (DCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DCL();
                }
            }
        }
        return INSTANCE;
    }
}
