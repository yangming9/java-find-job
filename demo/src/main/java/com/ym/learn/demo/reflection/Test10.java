package com.ym.learn.demo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test10 {
    //普通方式调用
    public static void test1(){
        User user = new User();

        long startTime = System.currentTimeMillis();

        for (int i = 1;i<10_0000_0000;i++){
            user.getName();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("普通方式执行10亿此时间： " +(endTime-startTime)+"ms");
    }

    //反射方式调用
    public static void test2() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<User> userClass = User.class;
        User user = userClass.newInstance();
        Method getName = userClass.getDeclaredMethod("getName",null);
        long startTime = System.currentTimeMillis();
        for (int i = 1;i<10_0000_0000;i++){
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射方式执行10亿此时间： " +(endTime-startTime)+"ms");
    }


    //反射方式调用  关闭检测
    public static void test3() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<User> userClass = User.class;
        User user = userClass.newInstance();
        Method getName = userClass.getDeclaredMethod("getName",null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 1;i<10_0000_0000;i++){
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射方式调用关闭安全检测执行10亿此时间： " +(endTime-startTime)+"ms");
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        test1();
        test2();
        test3();
    }
}
