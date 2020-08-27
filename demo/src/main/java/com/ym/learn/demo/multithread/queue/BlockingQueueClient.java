package com.ym.learn.demo.multithread.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueClient {
    public static void main(String[] args) {
        WorkDesk workDesk = new WorkDesk();
        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer("producer-1-", workDesk);
        Producer producer1 = new Producer("producer-2-", workDesk);

        Consumer consumer = new Consumer("consumer-1-", workDesk);
        Consumer consumer1 = new Consumer("consumer-2-", workDesk);

        service.submit(producer);
        service.submit(producer1);
        service.submit(consumer);
        service.submit(consumer1);

    }
}
