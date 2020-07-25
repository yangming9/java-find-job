package com.ym.learn.demo.threadpool;

import java.lang.ref.WeakReference;

/**
 * 虚引用
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }


}
