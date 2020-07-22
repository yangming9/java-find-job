package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.iterator;

import java.util.Iterator;
import java.util.List;

public class OutPutImpl {
    //学院集合
    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    //遍历所有的学院  然后调用 输出学院
    public void printCollege(){

        Iterator<College> iterator = collegeList.iterator();

        while (iterator.hasNext()){
            College college = iterator.next();
            System.out.println("------"+college.getName()+"------");
            printDepartment(college.createIterator());
        }
    }

    //输出  学院输出系
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department department = (Department) iterator.next();
            System.out.println(department.getName());
        }
    }
}
