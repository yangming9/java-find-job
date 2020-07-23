package com.ym.learn.demo.algorithm.shangguigusorts;

import java.util.Arrays;

/**
 * 堆排序：是以树结构为基础的  复杂度为O(nlogn) 线性对数阶
 * 堆是一种特殊的完全二叉树：每个结点的值都大于或等于其左右孩子的节点的值，称为大顶堆：没有要求节点的左右孩子的值大小关系
 * 每个结点的值都小于或等于其左右孩子节点的值称为小顶堆
 * 堆排序基本思想：树是以数组形式存放的
 * 1.将待排序序列构造成一个大顶堆
 * 2.此时，整个序列的最大值就是堆顶的根节点
 * 3.将其与末尾元素进行交换，此时末尾就是最大值
 * 4.然后将剩余n-1个元素重新构造成一个大顶堆，这样会得到n个元素的次小值。反复进行得到有序序列
 * 注意：
 * 一般升序采用大顶堆  降序采用小顶堆
 */
public class HeapSort {
    public static void main(String[] args) {
        //对数组进行升序排列
        int arr[] = {4, 6, 8, 5, 9,-1,90,89,56};
        int arr_new[] = new int[8000000];
        for (int i = 0;i<8000000;i++){
            arr_new[i] = (int)(Math.random()*8000000);
        }
        long startTime = System.currentTimeMillis();
        heap_sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序时间为："+(endTime-startTime));
        System.out.println(Arrays.toString(arr));
    }

    //编写一个堆排序的方法
    public static void heap_sort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序");
        for (int i = arr.length/2-1;i>=0;i--){//此for循环是为了将数组调整为大顶堆
            adjustHeap2(arr,i,arr.length);
        }

        for (int j = arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap2(arr,0,j);
        }
    }
    //将一个数组（二叉树）调整为一个大顶堆

    /**
     * 功能：完成 将以 i对应的非叶子节点的树调整成大顶堆
     * 举例：{4, 6, 8, 5, 9}=> i=1 =>adjustHeap => {4,9,8,5,6}
     * 再次调用  i= 0 => adjustHeap = > {9,6,8,5,4}
     * @param arr  待调整的数组
     * @param i  表示非叶子节点在数组中的索引  第一个非叶子节点索引
     * @param length  表示对多少个元素进行调整  length是在逐渐减少
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];// 先取出当前元素的值，保存在临时变量
        //开始调整
        /**
         * 说明
         * 1.k = i*2+1 k是i节点的左子节点
         */
        for (int k = i*2+1;k<length;k=k*2+1){
            //查看左右节点哪个大
            if ((k+1)<length && arr[k]<arr[k+1]){//说明左子节点小于右子节点的值
                k++;
            }

            if (arr[k]>temp){//子节点中较大的值  大于父节点
                arr[i] = arr[k];//把较大的值赋值给当前节点
                i=k;//i指向k  继续循环比较
            }else {
                break;
            }
        }
        //for循环结束后，我们已经将以i为父节点的树的最大值放在了最顶（局部）
        arr[i] = temp;//将temp值放到调整后的位置
    }

    //调整小顶堆的基础函数
    public static void adjustHeap2(int arr[],int i,int length){
        int temp = arr[i];// 先取出当前元素的值，保存在临时变量
        //开始调整
        /**
         * 说明
         * 1.k = i*2+1 k是i节点的左子节点
         */
        for (int k = i*2+1;k<length;k=k*2+1){
            //查看左右节点哪个大
            if ((k+1)<length && arr[k]>arr[k+1]){//说明左子节点小于右子节点的值
                k++;
            }

            if (arr[k]<temp){//子节点中较大的值  大于父节点
                arr[i] = arr[k];//把较大的值赋值给当前节点
                i=k;//i指向k  继续循环比较
            }else {
                break;
            }
        }
        //for循环结束后，我们已经将以i为父节点的树的最大值放在了最顶（局部）
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
