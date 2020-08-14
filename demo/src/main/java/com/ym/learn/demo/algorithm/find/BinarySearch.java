package com.ym.learn.demo.algorithm.find;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(binary_search_skr(arr,0,arr.length-1,1000));
        int arr2[] = {1,1,8,10,89,1000,1000,1000,1234};
        List<Integer> list = binary_search_improve(arr2, 0, arr2.length - 1, 1);
        System.out.println(list);
    }

    /**
     * 非递归
     * @param arr
     * @param findVal
     * @return
     */
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

    /**
     * 采用递归的方式
     * @return
     */
    private static int binary_search_skr(int arr[],int left,int right,int findVal){
        if (left>right)
        return -1;
        int mid = left+(right-left)/2;
        int midVal = arr[mid];
        if (findVal>midVal){
            return binary_search_skr(arr, mid+1, right, findVal);
        }else if (findVal<midVal){
            return binary_search_skr(arr, left, mid-1, findVal);
        }else {
            return mid;
        }
    }

    /**
     * 如果一个有序数组中有多个相同的值，该怎么处理
     * 思路分析：
     * 1.在找到mid值后不要马上返回
     * 2.向mid索引值左边进行扫描，将满足条件的下标记录下来
     * 3.向mid右边进行扫描，将满足条件的下标记录下来
     * 4.将所有满足条件的下标进行返回
     * @return
     */
    private static List<Integer> binary_search_improve(int arr[],int left,int right,int findVal){

        if (left>right)
            return new ArrayList<>();
        int mid = left+(right-left)/2;
        int midVal = arr[mid];
        if (findVal>midVal){
            return binary_search_improve(arr, mid+1, right, findVal);
        }else if (findVal<midVal){
            return binary_search_improve(arr, left, mid-1, findVal);
        }else {
            ArrayList<Integer> resList = new ArrayList<>();
            int temp = mid -1;
            while (true){
                if (temp<0 || arr[temp] != findVal){
                    break;
                }
                resList.add(temp--);
            }
            resList.add(mid);
            temp = mid+1;
            while (true) {
                if (temp>arr.length-1 || arr[temp] != findVal){
                    break;
                }
                resList.add(temp++);
            }
            return resList;
        }
    }
}
