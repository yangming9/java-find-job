package com.ym.learn.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程之间的通信问题：生产者和消费者问题！
 * 线程交替执行 A B操作同一个变量 num=0
 */
public class A {

    public static void main(String[] args) {
        Data data = new Data();

    }

static class Data {

 private int number = 0;

 Lock lock = new ReentrantLock();

 Condition condition = lock.newCondition();

        public void increment() throws InterruptedException {
            lock.lock();
            try {
                while (number != 0) {
                    condition.await();
                }
                number++;
                System.out.println(Thread.currentThread().getName() + "=>" + number);
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void decrement() {
            lock.lock();
            try {
                while (number == 0) {
                    condition.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName() + "=>" + number);
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
