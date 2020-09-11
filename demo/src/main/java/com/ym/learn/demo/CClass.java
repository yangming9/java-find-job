package com.ym.learn.demo;

public class CClass extends BClass{
    public CClass(){
        System.out.println("C class");
    }
    public static void main(String[] args){
        AClass c=new CClass();
        c.doPrint();
    }
}
