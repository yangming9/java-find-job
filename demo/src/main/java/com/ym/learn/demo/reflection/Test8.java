package com.ym.learn.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获得类的信息
 */
public class Test8 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.ym.learn.demo.reflection.User");
        //获得类的名字
        System.out.println(aClass.getName());//获得包名  和类名
        System.out.println(aClass.getSimpleName());//获得类名

        User user = new User();
        aClass = user.getClass();
        System.out.println(aClass.getName());//获得包名  和类名
        System.out.println(aClass.getSimpleName());//获得类名

        //获得类的属性
        // Field[] fields = aClass.getFields();只能找到public属性
        Field[] fields = aClass.getDeclaredFields();//获得全部属性
        for (Field field:fields){
            System.out.println(field);
        }

        Field name = aClass.getDeclaredField("name");
        System.out.println(name);

        //获得所有方法
        Method[] methods = aClass.getMethods();//获得本类及其父类的全部public方法
        for (Method method:methods) {
            System.out.println(method);
        }
        //获取本类所有方法
        methods = aClass.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println(method);
        }

        //获得指定方法
        Method method = aClass.getMethod("getName", null);
        Method setName = aClass.getMethod("setName", String.class);//因为有重载，所以需要参数
        System.out.println(method);
        System.out.println(setName);

        //获取指定的构造器
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor:constructors){
            System.out.println(constructor);
        }

        constructors = aClass.getDeclaredConstructors();
        for (Constructor constructor:constructors){
            System.out.println(constructor);
        }
    }
}
