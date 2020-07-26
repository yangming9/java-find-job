package com.ym.learn.demo.algorithm.shangguigusorts;

/**
 * 归并排序  O(nlogn) 线性对数阶
 * 采用分治策略  将大的问题分解为小的问题 然后递归求解
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[8_000_000];
        for (int i = 0; i < 8_000_000; i++) {
            arr[i] = (int) (Math.random() * 8_000_000);
        }
        int temp[] = new int[arr.length];
        long startTime = System.currentTimeMillis();
        merge_sort(arr,0,arr.length-1,temp);
        long endTime = System.currentTimeMillis();
        System.out.println("排序时间为：" + (endTime - startTime));
    }

    private static void merge_sort(int arr[],int left,int right,int temp[]){
        if (left<right){
            int mid = (left+right)/2;//中间索引
            //向左递归进行分解
            merge_sort(arr, left, mid, temp);
            //向右递归分解
            merge_sort(arr, mid+1, right, temp);
            //到合并
            merge(arr,left,mid,right,temp);
        }
    }

    //合并过程
    /**
     *
     * @param arr  待排序数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right   最右边索引
     * @param temp  中转数组
     */
    private static void merge(int arr[],int left,int mid,int right,int temp[]){
        int i = left;//左边有序序列的初始索引
        int j= mid+1;//右边有序序列的初始索引
        int t=0;//中转数组的初始索引

        //1.先把左右两边（有序）的数据按照规则填充到temp数组，直到左右两边有序序列有一边处理完毕为止
        while (i<=mid && j<= right){
            /**
             * 1.如果左边的元素小于右边的元素，则将左边的元素拷贝到temp数组
             * 2.如果右边的元素大于左边的元素，则右边的拷贝到temp数组
             */
            if (arr[i]<=arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //2.将有剩余数据的一方填充到temp数组中
        while (i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        //3.将temp数组的元素拷贝到arr
        //注意并不是每次都拷贝所有 这里是递归调用
        t=0;
        int tempLeft = left;
        while (tempLeft<= right){
            arr[tempLeft++] = temp[t++];
        }
    }


}
