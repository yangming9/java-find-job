package com.ym.learn.demo.base;

/**
 * java中基础数据类型有8中
 * byte
 * short
 * char
 * int
 * boolean
 * long
 * double
 * float
 */
public class BaseType {
   private byte str;//1
   private short strShort;//2
   private char c;//2
   private int num;//4
   private boolean b;//1
   private long aLong;//8
   private double aDouble;//8
   private float aFloat;//4

    public static void main(String[] args) {
        BaseType baseType = new BaseType();
    }

    public byte getStr() {
        return str;
    }

    public void setStr(byte str) {
        this.str = str;
    }

    public short getStrShort() {
        return strShort;
    }

    public void setStrShort(short strShort) {
        this.strShort = strShort;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }
}
