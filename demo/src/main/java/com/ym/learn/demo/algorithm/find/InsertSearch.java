package com.ym.learn.demo.algorithm.find;

/**
 * 插值查找算法  时间复杂度 O(logN)
 * mid下标的计算公式：
 * int mid = left + (right-left)*(findVal - arr[left])/(arr[right]-arr[left])
 * 适用场景：
 * 1）对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找速度较快
 * 2）关键字分布不均匀（跳跃性很大）的情况下，该方法不一定比折半查找要好
 */
public class InsertSearch {
    public static void main(String[] args) {
        int arr[] = new int[1000];
        for (int i = 0;i<1000;i++){
            arr[i] = i+1;
        }
        System.out.println(insert_search(arr, 0, arr.length - 1, 444));
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
        System.out.println("find ci shu");
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
