package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.proxy.quiet;

public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target;//目标对象 通过接口聚合

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("代理对象开始代理。。。");
        target.teach();
        System.out.println("代理结束。。。提交。。。");
    }
}
