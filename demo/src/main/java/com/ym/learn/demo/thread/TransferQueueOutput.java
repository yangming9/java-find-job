package com.ym.learn.demo.thread;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * 同步队列
 */
public class TransferQueueOutput {
    private static volatile boolean tsStarted = false;
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        //阻塞的容量为0 的队列
        //如有一个线程往队列放一个东西，此时线程停止，直到另外一个队列进来拿东西，线程才会继续运行，否则一直处于阻塞状态
        //这种队列生产者和消费者必须同步出现
        TransferQueue<Character> queue = new LinkedTransferQueue<>();//容量为0的队列

        new Thread(() ->{
            try {
                for (char c:aI){
                    queue.transfer(c);
                    tsStarted = true;
                    System.out.print(queue.take());
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() ->{
            try {
                for (char c:aC){
                    queue.transfer(c);//将字母a放入队列
                    System.out.print(queue.take());
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"t2").start();

    }
}
