package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College {

    List<Department> departmentList;

    public InfoCollege() {
        departmentList = new ArrayList<>();

        addDepartment("信息安全","信息安全专业");
        addDepartment("网络安全","网络安全专业");
        addDepartment("SERVER","SERVER SAFE");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String des) {
        Department department = new Department(name, des);
        departmentList.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}
