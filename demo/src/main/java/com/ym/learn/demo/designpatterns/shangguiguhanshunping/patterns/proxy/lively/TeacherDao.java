package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.proxy.lively;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师正在授课中");
    }
}
