package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.combination;

public class Client {
    public static void main(String[] args) {
        //从大到小创建对象  学校
        OrganizationComponent university = new University("清华大学", "中国顶级大学");
        //创建学院
        OrganizationComponent computerCollege = new College("计算机学院", "最厉害的学院");
        OrganizationComponent infoCollege = new College("信息工程学院", "最牛逼专业学院");

        //创建各个学院下面你的系（专业）
        computerCollege.add(new Department("软件工程专业","不错"));
        computerCollege.add(new Department("网络工程","不错啊"));
        computerCollege.add(new Department("计算机科学与技术","good"));

        infoCollege.add(new Department("通信工程","god"));
        infoCollege.add(new Department("信息工程","very good"));

        university.add(computerCollege);
        university.add(infoCollege);

        university.print();
    }
}
