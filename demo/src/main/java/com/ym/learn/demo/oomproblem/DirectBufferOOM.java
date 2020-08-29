package com.ym.learn.demo.oomproblem;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 直接内存溢出
 * 除了使用堆内存外，还可能使用直接内存，即堆外内存
 * NIO为了提高性能，避免在Java Heap和native Heap中切换，所以使用直接内存
 * 默认情况下，直接内存的大小和内存大小一致。
 * 堆外内存不受JVM的限制，但是受制于机器整体内存的大小限制
 * 如下代码设置堆最大内存为128M，直接内存为100M，然后我们每次分配1M放到list里边
 * -Xmx128M  -XX:MaxDirectMemorySize=100M
 * 当输出100次的时候，下次再分配的时候会报OOM-Direct buffer memory
 * 这时候是使用直接内存造成溢出，需要检查一下程序里面是否使用的NIO，比如Netty里面的直接内存配置
 */
public class DirectBufferOOM {
    public static void main(String[] args) {
        final int _1M = 1024*1024*1;
        List<ByteBuffer> buffers = new ArrayList<>();
        int count = 1;
        while (true){
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1M);
            buffers.add(byteBuffer);
            System.out.println(count++);
        }
    }
}
