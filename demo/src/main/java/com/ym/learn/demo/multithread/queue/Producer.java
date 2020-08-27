package com.ym.learn.demo.multithread.queue;

public class Producer implements Runnable{
    private String producerName;
    private WorkDesk workDesk;

    public Producer(String producerName, WorkDesk workDesk) {
        this.producerName = producerName;
        this.workDesk = workDesk;
    }

    @Override
    public void run() {
        try {
            while (true){
                workDesk.washDish();
                System.out.println(producerName+"洗好一个盘子");
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
