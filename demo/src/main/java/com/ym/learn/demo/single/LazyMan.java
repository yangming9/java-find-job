package com.ym.learn.demo.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//懒汉式单例
public class LazyMan {
    private LazyMan() {
        synchronized (LazyMan.class){
            if (lazyMan != null){
                throw new RuntimeException("试图反射破坏");
            }
        }
        System.out.println(Thread.currentThread().getName()+" ok");
    }
    private volatile static LazyMan lazyMan;

    public static LazyMan getInstance(){
        if (lazyMan == null){
            synchronized (LazyMan.class){
                if (lazyMan == null) {
                    lazyMan = new LazyMan();//极端情况下不是原子性操作
                    //1.分配内存空间
                    //2.执行构造方法，初始化对象
                    //3.把这个对象指向这个空间
                }
            }
        }

        return lazyMan;
    }

    //反射
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
declaredConstructor.setAccessible(true);//无视私有构造器
        LazyMan instance2 = declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
//    public static void main(String[] args) {
//        for (int i = 1;i<=10;i++){
//            new Thread(() -> {
//                LazyMan.getInstance();
//            }).start();
//        }
//    }
}
