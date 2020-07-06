package com.ym.learn.demo.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);

        new Thread(futureTask,"A").start();

        String future = (String) futureTask.get();
        System.out.println(future);
    }

    static class MyThread implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "callable";
        }
    }
}
