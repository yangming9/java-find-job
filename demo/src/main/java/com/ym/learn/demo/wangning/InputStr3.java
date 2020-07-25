package com.ym.learn.demo.wangning;

public class InputStr3 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(2222222));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 ) {
            return false;
        }
        String str = x + "";
        String sStr = str.substring(0,str.length()/2);
        if (str.length() == 1){
            return true;
        }
        System.out.println(sStr);
        StringBuffer sb = new StringBuffer();
        for (int i = str.length()-1; i >= ((str.length()-1)/2)+1; i--) {
            sb.append(str.charAt(i));
        }
        String xStr = sb.toString();
        System.out.println(xStr);
        return sStr.equals(xStr);
    }
}
