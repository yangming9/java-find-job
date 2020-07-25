package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.visitor;

import java.util.LinkedList;
import java.util.List;

public class ObjectStructure {
    //维护了一个集合
    private List<Person> personList = new LinkedList<>();

    //增加到list
    public void attache(Person person){
        personList.add(person);
    }

    //移除
    public void detach(Person person){
        personList.remove(person);
    }

    //显示测评情况
    public void display(Action action){
        for (Person person : personList) {
            person.accept(action);
        }
    }
}
