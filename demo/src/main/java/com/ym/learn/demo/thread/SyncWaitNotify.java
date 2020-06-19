package com.ym.learn.demo.thread;

/**
 * 最符合的情况
 * 肯定是要加锁
 * wait()  是指让持有线程锁的线程wait
 * notify()
 */
public class SyncWaitNotify {

    private static volatile boolean tsStarted = false;

    public static void main(String[] args) throws Exception {

        final Object o = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {

            synchronized (o) {
                for (char c : aI) {
                    System.out.print(c);

                    tsStarted = true;
                    try {
                        o.notify();
                        o.wait();//释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();

        new Thread(() -> {

            while (!tsStarted){

                try {
                    o.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            synchronized (o) {
                for (char c : aC) {
                    System.out.print(c);

                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}
