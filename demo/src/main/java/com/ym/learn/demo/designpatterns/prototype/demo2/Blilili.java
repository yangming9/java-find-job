package com.ym.learn.demo.designpatterns.prototype.demo2;

import com.ym.learn.demo.designpatterns.prototype.demo1.Video;

import java.util.Date;

/**
 * 客户端 实现克隆  这里是 浅拷贝  深拷贝就是改造方法
 */
public class Blilili {

    public static void main(String[] args) throws CloneNotSupportedException {
        //原型对象

        Date date = new Date();

        Video v1 = new Video("yangming learning", date);
        Video v2 = (Video)v1.clone();

        System.out.println("v1=>"+v1);
        System.out.println("v2=>"+v2);

        // 克隆
        v2.setName("kelong");

        System.out.println("v1=>"+v1);
        System.out.println("v2=>"+v2);
    }
}
