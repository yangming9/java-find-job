package com.ym.learn.demo.leetcode;

/**
 * 压缩字符串
 */
public class Number192 {
    public static void main(String[] args) {
        char[] chars = {'a','b','b','c','c'};
        System.out.println(compress2(chars));
    }
    public static int compress(char[] chars) {
        int top = 0;//栈顶索引
        int ctop = 0;//字符栈顶索引
        int count = 1;
        //chars[ctop] = chars[0];       //入栈一个初始元素(其实不需要这一步)
        for (int i = 1; i < chars.length; i++) {
            if (chars[ctop] != chars[i]) {//比较字符栈顶与遍历到的字符
                top++;
                chars[top] = chars[i]; //不同，入栈
                ctop = top;            //记录新的字符栈顶
                count = 1;
            } else {
                count++;                //相同，计数+1
                if (count > 1) {        //count大于1，需要让count入栈
                    top = ctop;         //先让栈顶回到字符栈顶
                    for (char c : String.valueOf(count).toCharArray()) {
                        top++;
                        chars[top] = c; //将count分成字符入栈
                    }
                }
            }
        }
        return top + 1; //top+1就是栈的size
    }

    /**
     * 采用滑动窗口的形式
     * @param chars
     * @return
     */
    public static int compress2(char[] chars) {
        if (chars.length == 0)
            return 0;
        //实现一  使用滑动窗口的思想
        int start = 0;
        int size = 0;
        for(int i=0;i<=chars.length;i++){
            if(i == chars.length || chars[start] != chars[i]){
                chars[size++] = chars[start];
                if(i - start > 1){
                    for(char c : String.valueOf(i-start).toCharArray()){
                        chars[size++] = c;
                    }
                }
            }
            start = i;
        }
        return size;
    }
}
