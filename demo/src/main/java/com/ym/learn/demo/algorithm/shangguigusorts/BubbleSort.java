package com.ym.learn.demo.algorithm.shangguigusorts;

import java.util.Arrays;

/**
 * 1.冒泡排序  时间复杂度为O(n^2)  就是每次排序选择一个最大值
 * 对待排序序列从前向后（从下标较小的元素开始）依次比较相邻的元素的值
 * 若发现逆序则交换，使值较大的元素逐渐从前移向后部，就想水底的气泡一样逐渐向上冒
 * 如果一趟比较下来没有进行过交换 说明序列有序  因此在排序过程中设置一个flag标志位
 * 判断元素是否进行过排序
 * 减少不必要的排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {5, 1, 12,5, 1, 12, -5, 16, -5, 16};
        bubble_sort(arr);
    }

    private static void bubble_sort(int arr[]) {
        /**
         * 第一趟排序就是将最大的数排在最后面
         * 第二趟排序就是将第二大的数排在倒数第二大的位置
         * 第n次就是将数据第n大数据放置相应的位置
         */
        int temp = 0;//临时变量
        for (int i= 0; i <arr.length-1;i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序结果："+Arrays.toString(arr));
        }
    }
}
