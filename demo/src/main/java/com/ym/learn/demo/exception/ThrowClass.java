package com.ym.learn.demo.exception;

import java.io.*;

/**
 * 关于异常的处理学习类
 */
public class ThrowClass {
    public static void main(String[] args) throws MyException {
        System.out.println(test());
    }

    private static void readFile(String filePath)throws IOException{
        File file = new File(filePath);
        String result;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while ((result = reader.readLine()) != null){
            System.out.println(result);
        }
        reader.close();
    }

    private static void readFile2(String filePath) throws MyException {
        File file = new File(filePath);
        String result;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while((result = reader.readLine())!=null) {
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("readFile method catch block.");
            MyException ex = new MyException("read file failed.");
            ex.initCause(e);
            throw ex;
        } finally {
            System.out.println("readFile method finally block.");
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int test(){
        int a = 1;
        int b = 2;
        try {
            System.out.println("***");
            return (a+b)/0;
        }catch (Exception e){
            System.out.println("***catch");
            System.out.println("test");
            return a-b;
        }finally {
            System.out.println("***finally");
            return a;
        }
    }





}
class MyException extends Exception {
    public MyException(){ }
    public MyException(String msg){
        super(msg);
    }
    // ...
}

