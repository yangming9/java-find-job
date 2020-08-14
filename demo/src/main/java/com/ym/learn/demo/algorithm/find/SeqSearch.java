package com.ym.learn.demo.algorithm.find;

public class SeqSearch {
    public static void main(String[] args) {
    int[] arr = {1,9,11,-1,34,89};//没有顺序的数组
        int index = seqSearch(arr,-1);
        System.out.println(index);
    }
    /**
     * 这里实现的是找到一个符合的值就返回
     * @param arr
     * @param value
     * @return
     */
    private static int seqSearch(int arr[],int value){
        //线性查找是逐一比对，发现相同就返回下标
        for(int i = 0;i<arr.length;i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
