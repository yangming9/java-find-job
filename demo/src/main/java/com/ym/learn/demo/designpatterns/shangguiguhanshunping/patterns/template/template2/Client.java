package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.template.template2;

public class Client {
    public static void main(String[] args) {
        System.out.println("=====只做红豆豆浆=====");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();

        System.out.println("=====制作黄豆豆浆=====");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();

        System.out.println("=====制作纯豆浆=====");
        SoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
