package com.ym.learn.demo.threadpool;

import java.lang.ref.SoftReference;

/**
 * 软引用   堆内存设置   参数:   -Xmx20M  堆内存最大20M
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        //栈 中 小 m  引用堆里面的 对象 （SoftReferenceDemo）  SoftReference又软软的指向了一个字节数组
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);//10M
        System.out.println(m.get());//拿到软引用中的内容
        System.gc();
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(m.get());//发现对象并没有被回收
        //在分配一个数组，heap将装不下，这时候系统会垃圾回收，如果不够，系统会吧软引用干掉
        byte[] b = new byte[1024*1024*15];
        System.out.println(m.get());
    }
}
