package com.ym.learn.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    private static volatile boolean tsStarted = false;
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();

        Condition conditionT1 = lock.newCondition();
        //Condition 是队列  synchronized是放在一个队列中
        //一个condition代表一个队列

        Condition conditionT2 = lock.newCondition();

        new Thread(() -> {

            try {
                lock.lock();

                for (char c : aI){
                    System.out.print(c);
                    tsStarted = true;
                    conditionT2.signal();//相当于notify
                    conditionT1.await();//相当于wait
                }

                conditionT2.signal();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(() -> {

            if (!tsStarted){

                try {
                    conditionT2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            try {
                lock.lock();

                for (char c : aC){
                    System.out.print(c);
                    tsStarted = false;
                    conditionT1.signal();//相当于notify
                    conditionT2.await();//相当于wait
                }

                conditionT1.signal();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
