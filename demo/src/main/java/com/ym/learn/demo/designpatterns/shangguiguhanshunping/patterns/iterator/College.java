package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.iterator;

import java.util.Iterator;

public interface College {
    String getName();
    //增加系的方法
    void addDepartment(String name,String des);
    //返回一个迭代器的方法 遍历
    Iterator createIterator();
}
