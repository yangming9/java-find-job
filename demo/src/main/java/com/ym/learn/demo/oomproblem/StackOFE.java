package com.ym.learn.demo.oomproblem;

/**
 * 栈溢出的第二种情况
 * 这就是栈的StackOverflow情况，下面就是一个死循环的递归调用
 * 运行之后，程序每次递归的时候，程序会把数据结果压入栈，包括里面的指针
 * 这个时候就需要帧栈大一些才能承受住更多的递归调用。通过-Xss进行设置
 * 遇到这种情况，那么就需要通过jstack将线程数据导到文件进行分析。找到递归的点
 * 如果程序就是需要递归的次数的话，那么这个时候就需要增大帧栈的大小以适应程序
 */
public class StackOFE {
    public static void stackOverflowErrorMethod(){
        stackOverflowErrorMethod();
    }

    public static void main(String[] args) {
        stackOverflowErrorMethod();
    }
}
