package com.ym.learn.demo.exception;

/**
 * 会执行，在return前执行
 */
public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println(getInt());
    }
    private static int getInt(){
        int a = 10;
        int b = 10;
        try {
            System.out.println((a+b)/0);
            a = 20;
        }catch (ArithmeticException e){
            System.out.println("catch");
            return a-b;
        }finally {
            System.out.println("finally");
        }
        return a;
    }
}
