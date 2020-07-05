package com.ym.learn.demo.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("计数器执行完成！");
        });

        for (int i = 0; i < 7; i++) {
            int temp = i;//for循环结束后，i的值就会消失或者改变，但是匿名内部类还可能存在，需要使用这个值，这样就会导致生命周期不同，因此需要用一个局部变量将这个值复制一份，保证值的生命周期
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " " + temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
