package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {

    List<Department> departmentList;//信息工程学院是以list方式存放

    int index = -1;

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {

        if (index >= departmentList.size()-1){
            return false;
        }else {
            index++;
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    @Override
    public void remove() {

    }
}
