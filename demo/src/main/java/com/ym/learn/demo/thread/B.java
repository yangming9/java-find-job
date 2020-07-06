package com.ym.learn.demo.thread;

public class B {
    public static void main(String[] args) {
        System.out.println(getValue(1000));
    }

    public static int getValue(int cap){
        int n = cap-1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
