package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.template.template1;

public class RedBeanSoyaMilk extends SoyaMilk {
    @Override
    protected void addCondiments() {
        System.out.println("第二步，加入上好得红豆");
    }
}
