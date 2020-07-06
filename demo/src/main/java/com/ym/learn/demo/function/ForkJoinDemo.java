package com.ym.learn.demo.function;

import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {

    private long start;
    private long end;

    private long temp = 10000L;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {

        }
    }

    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {//fork join
            long middle = (end + start) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();//拆分任务
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
