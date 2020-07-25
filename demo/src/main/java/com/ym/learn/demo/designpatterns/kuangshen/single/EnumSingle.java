package com.ym.learn.demo.designpatterns.kuangshen.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//枚举 本身也是一个class  不允许使用反射进行破坏
public enum  EnumSingle {
    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }

    static class test{
        public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            EnumSingle instace1 = EnumSingle.INSTANCE;
            Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,Integer.class);
            declaredConstructor.setAccessible(true);
            EnumSingle instance2 = declaredConstructor.newInstance();
            System.out.println(instace1);
            System.out.println(instance2);
        }
    }
}
