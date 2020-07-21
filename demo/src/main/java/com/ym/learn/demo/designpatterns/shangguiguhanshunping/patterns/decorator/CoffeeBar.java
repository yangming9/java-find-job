package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.decorator;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class CoffeeBar {
    public static void main(String[] args) throws IOException {
        //装饰者模式下的订单：2份巧克力+一份牛奶的longBlack
        //1.点一份long black
        Drink order = new LongBlack();
        System.out.println("费用1= "+order.cost());
        //2.加一份牛奶
        order = new Milk(order);
        System.out.println("加入一份牛奶后的费用："+order.cost());

        order = new Chocolate(order);
        System.out.println("加入一份巧克力后的费用："+order.cost());
        System.out.println(order.getDes());

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("D:/test.txt"));
        System.out.println(dataInputStream.read());
        dataInputStream.close();
    }
}
