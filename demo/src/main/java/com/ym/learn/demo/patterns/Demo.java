package com.ym.learn.demo.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class Demo {
    public static void main(String[] args) {
        String str = "asdafgdsga";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(str);
        System.out.println(m.matches());
    }



}
