package com.ym.learn.demo.annotation;

import java.util.ArrayList;
import java.util.List;

public class Test extends Object {

    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    @SuppressWarnings("all")//镇压警告
    public void test02(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
