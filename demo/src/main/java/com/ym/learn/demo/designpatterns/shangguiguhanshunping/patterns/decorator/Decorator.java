package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.decorator;

//和父类是继承+组合的关系  该类是装饰类  含有一个被装饰对象
public class Decorator extends Drink {

    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        //getPrice 自己价格
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        return super.des + " " + super.getPrice() + "&&" + drink.getDes();
    }
}
