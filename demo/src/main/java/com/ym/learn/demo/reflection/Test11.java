package com.ym.learn.demo.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//反射操作注解
public class Test11 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.ym.learn.demo.reflection.Student2");

        //通过反射获得注解
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value值
        TableYang annotation = aClass.getAnnotation(TableYang.class);
        String value = annotation.value();
        System.out.println(value);

        //获得类指定的注解
        Field name = aClass.getDeclaredField("name");
        FieldYang fieldYang = name.getAnnotation(FieldYang.class);
        System.out.println(fieldYang.columnName());
        System.out.println(fieldYang.length());
        System.out.println(fieldYang.type());
    }
}

@TableYang("db_student")
class Student2 {
    @FieldYang(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldYang(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FieldYang(columnName = "db_name", type = "varchar", length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TableYang {
    String value();
}

//属性注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldYang {
    String columnName();

    String type();

    int length();
}