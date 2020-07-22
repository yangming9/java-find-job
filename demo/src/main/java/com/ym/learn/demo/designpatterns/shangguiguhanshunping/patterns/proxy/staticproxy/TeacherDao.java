package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.proxy.staticproxy;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("teacher 授课中");
    }
}
