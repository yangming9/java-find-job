package com.ym.learn.demo.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo {

    public static AtomicInteger ON_LINE_SERVICE = new AtomicInteger(1);

    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(2020);
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(1,1);
        new Thread(() -> {
            int stamp = atomicInteger.getStamp();//获得版本号
            System.out.println("a1 =>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicInteger.compareAndSet(1, 2, atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("a2 =>"+atomicInteger.getStamp());

            System.out.println(atomicInteger.compareAndSet(2, 1, atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("a3 =>"+atomicInteger.getStamp());
        },"a").start();
        //与乐观锁是相同的
        new Thread(() -> {
            int stamp = atomicInteger.getStamp();//获得版本号
            System.out.println("b1 =>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicInteger.compareAndSet(1, 6, stamp, stamp + 1));
            System.out.println("b2 =>"+stamp);
        },"b").start();



        //        /**
//         * 期望、更新
//         *
//         * public final boolean compareAndSet(int expect, int update)
//         *
//         * 如果期望值达到了，那么就跟新，否则就不更新 CAS 是 CPU的并发原语
//         */
//        atomicInteger.compareAndSet(2020,2021);
//        System.out.println(atomicInteger.get());
//
//        atomicInteger.compareAndSet(2021 ,2020);
//        System.out.println(atomicInteger.get());
//
//        atomicInteger.compareAndSet(2020,6666);
//        System.out.println(atomicInteger.get());

    }
}
