package com.ym.learn.demo.algorithm.find;

/**
 * 插值查找算法
 * mid下标的计算公式：
 * int mid = left + (right-left)*(findVal - arr[left])/(arr[right]-arr[left])
 */
public class InsertSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0;i<100;i++){
            arr[i] = i+1;
        }
        System.out.println(insert_search(arr, 0, arr.length - 1, 1001));
    }

    /**
     * 要求数组是有序的
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    private static int insert_search(int arr[],int left,int right,int findVal){
        if (left>right || findVal<arr[0] || findVal> arr[arr.length-1]){
            return -1;
        }
        int mid = left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal = arr[mid];
        if (findVal>midVal){//说明向右递归查找
            return insert_search(arr, mid+1, right, findVal);
        }else if (findVal < midVal){
            return insert_search(arr, left, mid-1, findVal);
        }else {
            return mid;
        }
    }
}
