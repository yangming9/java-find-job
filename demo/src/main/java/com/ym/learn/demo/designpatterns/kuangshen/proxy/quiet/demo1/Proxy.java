package com.ym.learn.demo.designpatterns.kuangshen.proxy.quiet.demo1;

public class Proxy implements Rent{
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    public Proxy() {
    }


    @Override
    public void rent() {
        seeHouse();
        host.rent();
        hetong();
        fare();
    }

    public void seeHouse(){
        System.out.println("中介可以带人看房");
    }

    public void fare(){
        System.out.println("收中介费");
    }

    public void hetong(){
        System.out.println("签合同");
    }
}
