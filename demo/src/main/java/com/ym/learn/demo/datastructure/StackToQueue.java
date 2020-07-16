package com.ym.learn.demo.datastructure;

import java.util.Stack;

/**
 * 使用栈实现队列
 */
public class StackToQueue {

    Stack<Integer> stackIn = new Stack<>();

    Stack<Integer> stackOut = new Stack<>();

    private void push(int data){
        //进行push操作之前保证出队为空
        while (!stackOut.isEmpty()){
            stackIn.push(stackOut.peek());
            stackOut.pop();
        }
        stackIn.push(data);
        System.out.println("入队列元素："+data);
    }

    private int pop(){
        //进行pop操作之前保证入队为空
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.peek());
            stackIn.pop();
        }
        int temp = stackOut.peek();
        stackOut.pop();
        System.out.println("出栈元素为："+temp);
        return temp;
    }

    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        queue.push(1);
        queue.push(3);
        queue.push(12);
        queue.pop();
        queue.pop();
        queue.push(0);
        queue.pop();
        queue.push(7);
        queue.pop();
        queue.pop();
    }
}
