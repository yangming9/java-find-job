package com.ym.learn.demo.multithread.queue;

public class Consumer implements Runnable {
    private String consumerName;
    private WorkDesk workDesk;

    public Consumer(String consumerName, WorkDesk workDesk) {
        this.consumerName = consumerName;
        this.workDesk = workDesk;
    }

    @Override
    public void run() {
        try {
            while (true){
                workDesk.useDish();
                System.out.println(consumerName+"使用了一个盘子");
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
