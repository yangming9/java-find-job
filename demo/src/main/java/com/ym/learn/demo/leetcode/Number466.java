package com.ym.learn.demo.leetcode;

import java.util.HashMap;

public class Number466 {
    public static void main(String[] args) {
        System.out.println(getMaxRepetitions("acb", 4, "ab", 2));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.size();
    }
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int length1 = s1.length();
        int length2 = s2.length();

        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        int index2 = 0;
        int size = 0;//循环次数
        for (int i=0;i<n1;i++){
            for (int index1=0;index1<length1;index1++){
                if (s1CharArray[index1] == s2CharArray[index2]){
                    index2++;
                }
                if (index2 == length2){
                    index2 = 0;
                    size++;
                }
            }
        }
        return size/n2;
    }
}
