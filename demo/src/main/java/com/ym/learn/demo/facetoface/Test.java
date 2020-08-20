package com.ym.learn.demo.facetoface;

/**
 * 面试题目1
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getDivision(10));
    }

    public static int getDivision(int n) {
        try {
            n += 1;//11
            if (n / 0 > 0) {
                n += 1;
            } else {
                n -= 10;//1
            }
            return n;
        } catch (Exception e) {
            n++;//12
        }
        n++;//13
        return n++;//先return  再  ++
    }
}
