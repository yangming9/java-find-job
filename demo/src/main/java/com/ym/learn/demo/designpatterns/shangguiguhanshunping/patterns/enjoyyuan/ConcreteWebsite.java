package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.enjoyyuan;

public class ConcreteWebsite extends Website {

    public ConcreteWebsite(String type) {
        this.type = type;
    }

    private String type = "";//网站的发布形式为  类型

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为： "+type+" 在使用中...使用者为："+user.getName());
    }
}
