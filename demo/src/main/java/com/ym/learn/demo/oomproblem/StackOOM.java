package com.ym.learn.demo.oomproblem;

import java.util.concurrent.TimeUnit;

/**
 * 栈溢出  第一种情况
 * 下面的代码就是无限创建线程，直到没法再创建线程
 * 设置栈帧大小  -Xss  缩小栈帧的大小  才能承受更多的线程数量
 * 以下这种情况就是栈帧不够用了，如果出现了这种情况，我们需要了解什么地方创建了很多线程
 * 线上程序需要用jstack命令，将当前线程的状态导出来放到文件里边，然后将文件进行分析。
 */
public class StackOOM {
    private static void infiniteRun(){
        while (true){
            Thread thread = new Thread(() -> {
                while (true){
                    try {
                        TimeUnit.HOURS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        infiniteRun();
    }
}
