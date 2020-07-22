package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.proxy.quiet;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("teacher 授课中");
    }
}
