package com.ym.learn.demo.multithread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkDesk {
    private BlockingQueue<String> desk = new LinkedBlockingQueue<>(10);
    public void washDish() throws InterruptedException{
        desk.put("盘子");
    }
    public void useDish() throws InterruptedException{
        desk.take();
    }
}
