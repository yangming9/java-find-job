package com.ym.learn.demo.algorithm.lookup;

import java.util.ArrayList;

/**
 * 二分查找
 * 思路：1.首先确定该数组的中间的下标
 * 2.然后让需要超找的数findVal和arr[mid]比较
 * 2.1findVal>arr[mid] 说明你要查找的数在mid的右边，因此需要递归向右查找
 * 2.2 findVal<arr[mid]说明在查找的数在mid的左边，需要递归向右查找
 * 2.3 如果findVal=arr[mid] 说明找到  返回
 * 注意
 * 二分查找的前提，该数组是有序数组
 * 1.找到就递归结束
 * 2.递归完整个数组，仍然找不到findVal，也需要结束递归 当 left>right就需要退出
 */
public class DichotomyLookUp {
    public static void main(String[] args) {
        int arr[]={1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(dichotomy_lookup_optimization(arr, 0, arr.length - 1, 1));
    }

    /**
     * @param arr  数组
     * @param left  左边界
     * @param right  右边界
     * @param findVal  要查找的值
     * @return 返回下标
     */
    private static int dichotomy_lookup(int arr[],int left,int right,int findVal){

        if (left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (findVal>midVal){
            return dichotomy_lookup(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return dichotomy_lookup(arr, left, mid-1, findVal);
        }else {
            return mid;
        }
    }

    /**
     * 优化二分查找  返回所有下标
     * int arr[]={1,8,10,10,89,1000,1000,1000,1234};
     * 思路：在找到值后不要马上返回，将下标加入集合中
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    private static ArrayList<Integer> dichotomy_lookup_optimization(int arr[], int left, int right, int findVal){
        if (left>right){
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (findVal>midVal){
            return dichotomy_lookup_optimization(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return dichotomy_lookup_optimization(arr, left, mid-1, findVal);
        }else {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int temp = mid-1;
            while (true){
                if (temp<0 || arr[temp] != findVal){
                    break;
                }
                arrayList.add(temp--);
            }
            arrayList.add(mid);
            temp = mid+1;
            while (true){
                if (temp>arr.length-1 || arr[temp] != findVal){
                    break;
                }
                arrayList.add(temp++);
            }

            return arrayList;
        }
    }
}
