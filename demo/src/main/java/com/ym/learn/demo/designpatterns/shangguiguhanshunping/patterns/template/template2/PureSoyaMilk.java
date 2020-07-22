package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.template.template2;
//纯豆浆
public class PureSoyaMilk extends SoyaMilk{
    @Override
    protected void addCondiments() {

    }

    @Override
    boolean customerWantCondiment() {
        return false;
    }
}
