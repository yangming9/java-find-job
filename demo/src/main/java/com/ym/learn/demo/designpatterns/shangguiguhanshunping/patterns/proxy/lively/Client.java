package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.proxy.lively;

/**
 * 代理对象不需要实现接口，但是目标对象要实现接口，否则不能用动态代理
 * 代理对象的生成  是利用jdk的api  动态在内存中创建代理对象
 *
 * 根据传入的对象（TeacherDao）目标对象
 * 利用反射机制返回一个代理对象
 * 然后通过代理对象  调用目标对象方法
 */
public class Client {
    public static void main(String[] args) {
        //创建目标对象
        TeacherDao teacherDao = new TeacherDao();
        //给目标对象生成代理对象  代理生成的是要代理的接口
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(teacherDao).getProxyInstance();

        proxyInstance.teach();

        proxyInstance.sayHello("tom");
    }
}
