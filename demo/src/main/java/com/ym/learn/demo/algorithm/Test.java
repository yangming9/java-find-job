package com.ym.learn.demo.algorithm;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Integer> start = new HashSet<>();
        HashSet<Integer> end = new HashSet<>();
        start.add(1);
        start.add(2);
        start.add(3);
        start.add(4);

        end.add(1);
        end.add(2);
        end.add(4);
        end.add(5);

        start.retainAll(end);
        System.out.println("start: "+start);
        System.out.println("end: "+end);

        String str = "ssss";
        str += str;
        System.out.println(str);
    }
}
