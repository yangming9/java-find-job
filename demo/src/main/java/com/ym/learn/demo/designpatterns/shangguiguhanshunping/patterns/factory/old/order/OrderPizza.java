package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.old.order;

import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.old.Pizza;
import com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.factory.simplefactory.SimpleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
//    public OrderPizza() {
//        Pizza pizza = null;
//        String orderType;//订购pizza的类型
//        do {
//            orderType = gettype();
//            if (orderType.equals("greek")) {
//                pizza = new GreekPizza();
//            } else if (orderType.equals("cheese")) {
//                pizza = new CheesePizza();
//            }else {
//                break;
//            }
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        } while (true);
//    }


    public OrderPizza(SimpleFactory simpleFactory) {
        setSimpleFactory(simpleFactory);
    }

    //    定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        String orderType = "";//用户输入的
        this.simpleFactory = simpleFactory;//设置简单工厂对象
        do {
            orderType = gettype();
            pizza = this.simpleFactory.createPizza(orderType);

            //输入pizza信息
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);
    }

    //写一个方法可以获取客户希望订购的pizza
    private String gettype() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
