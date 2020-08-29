package com.ym.learn.demo.oomproblem;

import java.util.ArrayList;

/**
 * 堆溢出异常
 * 堆内对象不能进行回收了，堆内存持续增大，这样达到了堆内存的最大值，数据满了，所以就出来了。
 * 需要设置好 VM Options：-Xmx100m 这样设置为最大堆内存，运行起来很快就出来错误了。
 * 找到问题点，分析哪个地方存储了大量类没有被回收的情况
 * 通过jmap命令将线上的堆内存导出来后进行分析
 */
public class HeapOOM {
    static class OOMObject{
    }
    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
