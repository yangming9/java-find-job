package com.ym.learn.demo.reflection;
//测试class类的创建方式有哪些
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 方式1. 通过对象获得
         * 方式2.通过forname
         * 方式3.通过类名 .class
         * 方式4.基本内置类型的包装类都有一个Type属性
         */
        Person person = new Student();
        System.out.println("这个人是： "+person.name);

        Class clazz = person.getClass();
        System.out.println(clazz.hashCode());

        Class clazz1 = Class.forName("com.ym.learn.demo.reflection.Person");
        System.out.println(clazz1.hashCode());

        Class clazz2 = Person.class;
        System.out.println(clazz2.hashCode());

        Class clazz3 = Integer.TYPE;
        System.out.println(clazz3);

        //获取父类属性
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);


    }
}
class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}
