package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.template.template2;

public class PeanutSoyaMilk extends SoyaMilk {
    @Override
    protected void addCondiments() {
        System.out.println("第二步，加入上好的花生");
    }
}
