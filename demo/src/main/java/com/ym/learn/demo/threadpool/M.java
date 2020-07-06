package com.ym.learn.demo.threadpool;

public class M {
    /**
     * 平时不要重写这个方法，会导致严重的OOM问题
     * @throws Throwable
     */
    @Override
    protected void finalize()throws Throwable{
        System.out.println("finalize");
    }
}
