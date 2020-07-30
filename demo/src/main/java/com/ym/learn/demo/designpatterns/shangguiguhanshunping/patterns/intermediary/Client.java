package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.intermediary;

/**
 * 中介者模式
 */
public class Client {
    public static void main(String[] args) {
        String str = "a";
        String needle = "a";
        int i = strStr(str, needle);
        System.out.println(i);
    }
    public static int strStr(String haystack, String needle) {
        //此处应使用滑动窗口的解法 找到与needle相等的子串
        if(needle.isEmpty()){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        int needleLength = needle.length();
        for(int i = 0;i<=haystack.length()-needleLength;i++){
            String temp = haystack.substring(i,i+needleLength);
            if(temp.equals(needle)){
                return i;
            }
        }
        return -1;
    }

}
