package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.proxy.staticproxy;

/**
 * 应用实例
 * 定义一个接口 ITeacherDao
 * 目标对象 TeacherDao 实现接口 ITeacherDao
 * 静态代理方式 就需要在TeacherDaoProxy实现 ITeacherDao
 */
public class Client {
    public static void main(String[] args) {
        //创建目标对象 被代理对象
        TeacherDao teacherDao = new TeacherDao();
        //创建代理对象  同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        teacherDaoProxy.teach();
    }
}
