package com.ym.learn.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test3 {

    @MyAnnotation3("name")
    @MyAnnotation2(name = "qwer",schools = {"哈工大","清华"},age = 20)
    public void test(){

    }
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数： 参数类型 + 参数名()
    String name() default "";

    int age() default 0;

    int id() default -1;//如果默认值为-1 代表不存在

    String[] schools();
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@interface MyAnnotation3{
    String value();
}
