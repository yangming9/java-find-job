package com.ym.learn.demo.oomproblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 堆内存太小的时候会报这个错误。
 * 如果98%的GC的时候回收不到2%的时候会报这个错误，也就是最小最大内存出现了问题的时候会报这个错误
 * 代码配置最小最大内存都为10M
 * 这个我们创建了一个线程池，如果线程池执行的时候如果核心线程处理不过来的时候会把数据放到
 * LinkedBlockingQueue里边，也就是堆内存中。这个时候我们需要检查 -Xms -Xmx 最小最大堆配置是否合理
 * 再一个dump出现当前内存来分析一下是否使用了大量的循环或使用大量内存代码
 * 简单来讲就是任务队列的堆积 导致的 GC失败 无法进行回收
 */
public class GCOverheadOOM {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i=0;i<Integer.MAX_VALUE;i++){
            executor.execute(() ->{
                try {
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    //do nothing
                }
            });
        }
    }
}
