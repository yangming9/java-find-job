package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.visitor;

public class Client {
    public static void main(String[] args) {
        //创建ObjectStructure
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attache(new Man());
        objectStructure.attache(new Woman());

        //成功
        Success success = new Success();

        objectStructure.display(success);

        //待定
        Wait wait = new Wait();

        objectStructure.display(wait);
    }
}
