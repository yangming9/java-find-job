package com.ym.learn.demo.threadpool;

import java.io.IOException;

/**
 * 强引用（或者叫普通引用）
 */
public class NormalReference {
    public static void main(String[] args) throws IOException {
        //小m指向了堆里面new出来的M
        M m = new M();
        m=null;
        System.gc();
        System.in.read();
    }
}
