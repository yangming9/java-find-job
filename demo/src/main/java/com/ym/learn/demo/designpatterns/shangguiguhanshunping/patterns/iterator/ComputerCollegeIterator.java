package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.iterator;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator {

    //这里需要知道department是怎么样方式存放
    Department[] departments;
    int position = 0;//遍历的位置

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {

        if (position >= departments.length || departments[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {

        Department department = departments[position];
        position++;
        return department;
    }

    //默认不实现
    @Override
    public void remove() {

    }
}
