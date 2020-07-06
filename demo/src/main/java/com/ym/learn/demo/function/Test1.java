package com.ym.learn.demo.function;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
        test2();
//        test3();
    }

    public static void test1() {
        long sum = 0L;
        long start = System.currentTimeMillis();
        for (long i = 0L; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + "时间： " + (end - start));
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        ForkJoinTask<Long> forkJoinTask = new ForkJoinDemo(0L, 10_1000_0000L);
//        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinTask);
//        long sum = submit.get();
        ForkJoinPool forkJoinPool = new ForkJoinPool(8);
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        // 提交任务
        Long sum = submit.get();
        long end = System.currentTimeMillis();

        System.out.println("sum = " + sum + "时间： " + (end - start));
    }

    //stream 并行流
    public static void test3() {
        long sum = 0L;
        long start = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(sum, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println("sum = " + reduce + "时间： " + (end - start));
    }
}
