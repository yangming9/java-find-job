package com.ym.learn.demo.algorithm.find;

/**
 * 二分查找必须在有序数组中使用
 * 如果是无需数组必须先转换为有序数组
 * 思路：
 * 1.首先确定该数组的中间下标  mid=(left+right)/2
 * 2.然后让需要查找的findVal和arr[mid]比较
 * 2.1findVal>arr[mid] 说明要查找的数在mid右边，因此需要递归的向右查找
 * 2.2indVal<arr[mid] 说明要查找的数在mid左边，因此需要递归的向左查找
 * 2.3findVal==arr[mid] 说明找到 就返回
 * 什么时候需要结束递归
 * 1）找到就递归
 * 2）递归完整个数组，仍然没有找到，就需要结束递归，当left>right就需要退出
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,8,10,89,1000,1234};
        System.out.println(binary_search(arr,1001));
    }
    private static int binary_search(int arr[],int findVal){
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while (left <= right){//结束递归的条件
            mid = left+(right-left)/2;
            if (findVal == arr[mid]){
                return mid;
            }
            if (findVal>arr[mid]){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }
}
