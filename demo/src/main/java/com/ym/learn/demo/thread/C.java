package com.ym.learn.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A执行完 调用B B调用C  C调用A
 */
public class C {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(() -> {
            for (int i = 0;i<10;i++){
                data3.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0;i<10;i++){
                data3.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0;i<10;i++){
                data3.printC();
            }
        }, "C").start();

    }

    static class Data3 {
        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        private Condition conditionC = lock.newCondition();
        private int number = 1;

        public void printA() {
            lock.lock();
            try {
                while (number != 1) {
                    conditionA.await();
                }
                number = 2;
                System.out.println(Thread.currentThread().getName() + "=>" + number);
                conditionB.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void printB() {
            lock.lock();
            try {
                while (number != 2) {
                    conditionB.await();
                }
                number = 3;
                System.out.println(Thread.currentThread().getName() + "=>" + number);
                conditionC.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printC() {
            lock.lock();
            try {
                while (number != 3) {
                    conditionC.await();
                }
                number = 1;
                System.out.println(Thread.currentThread().getName() + "=>" + number);
                conditionA.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
