package com.ym.learn.demo.wangning;

import java.util.ArrayList;
import java.util.Scanner;

public class InputStr2 {
    public static void main(String[] args) {
        /**
         * 1.先用一个hashMap<K,V> 存储第一行所有的字符串  相同字串的字串长度作为key  字母作为value
         * 2.输入第几长度 取到key值即可
         */
        System.out.println("请输入字符：");
        ArrayList list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            String str = scanner.next();
            list.add(str);
        }
        list.forEach(System.out::print);
        scanner.close();
    }
}
