package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.combination;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {

    public College(String name, String des) {
        super(name, des);
    }

    //存放的是department
    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    //输入包含的专业
    @Override
    protected void print() {
        System.out.println("======="+getName()+"==========");
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}
