package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {
    Department[] departments;
    int numOfDepartment = 0;//保存当前数组的对象个数

    public ComputerCollege() {
        departments = new Department[4];
        addDepartment("java","java专业");
        addDepartment("boot","boot专业");
        addDepartment("spring","spring专业");
        addDepartment("mybatis","mybatis专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String des) {
        Department department = new Department(name, des);
        departments[numOfDepartment++] = department;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
