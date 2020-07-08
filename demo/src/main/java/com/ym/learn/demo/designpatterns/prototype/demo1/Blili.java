package com.ym.learn.demo.designpatterns.prototype.demo1;

import java.util.Date;

/**
 * 客户端 实现克隆  这里是 浅拷贝  深拷贝就是改造方法
 */
public class Blili {

    public static void main(String[] args) throws CloneNotSupportedException {
        //原型对象

        Date date = new Date();

        Video yangming_learning = new Video("yangming learning", date);
        System.out.println("v1=>"+yangming_learning);
        System.out.println("v1=>hash:"+yangming_learning.hashCode());


        // 克隆
        Video yangming_learning1 = (Video)yangming_learning.clone();
        yangming_learning1.setName("kelong");
        System.out.println("v2=>"+yangming_learning1);
        System.out.println("v2=>hash:"+yangming_learning1.hashCode());
    }
}
