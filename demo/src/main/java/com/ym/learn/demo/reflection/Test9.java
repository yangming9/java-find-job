package com.ym.learn.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test9 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class<?> aClass = Class.forName("com.ym.learn.demo.reflection.User");

        //构造一个对象
        User user = (User) aClass.newInstance();//本质 调用无参构造器
        System.out.println(user);

        //通过构造器创建对象
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) declaredConstructor.newInstance("yangming", 001, 18);
        System.out.println(user2);


        //通过反射调用方法
        User user3 = (User)aClass.newInstance();
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        //invoke（）方法，激活的意思，参数列表（对象，方法的值）
        setName.invoke(user3,"yangming8");
        System.out.println(user3.getName());

        //通过反射操作属性
        //不能直接操作私有属性  需要关闭程序的安全检测
        User user4 = (User)aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user4,"yangming9");
        System.out.println(user4.getName());
    }
}
