package com.ym.learn.demo.reflection;

public class Test extends Object {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class aClass = Class.forName("com.ym.learn.demo.reflection.User");
        System.out.println(aClass);
        Class aClass1 = Class.forName("com.ym.learn.demo.reflection.User");
        Class aClass2 = Class.forName("com.ym.learn.demo.reflection.User");
        Class aClass3 = Class.forName("com.ym.learn.demo.reflection.User");
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());
    }

}
class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
