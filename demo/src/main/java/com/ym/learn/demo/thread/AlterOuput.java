package com.ym.learn.demo.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * 题目为线程交替输出
 * 利用 LockSupport
 */
public class AlterOuput {
    static Thread t1 = null,t2 = null;

    public static void main(String[] args) throws Exception{
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : aI){
                System.out.println(c);
                LockSupport.unpark(t2);//叫醒t2
                LockSupport.park();//阻塞t1
            }
        },"t1");

        t2 = new Thread(() -> {

            for (char c : aC){
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
