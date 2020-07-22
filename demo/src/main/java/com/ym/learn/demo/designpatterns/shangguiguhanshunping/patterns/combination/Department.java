package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.combination;
//add remove 方法不用重写了  因为此类是叶子节点  不用管理其他单位
public class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}
