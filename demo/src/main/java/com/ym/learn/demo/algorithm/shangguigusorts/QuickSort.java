package com.ym.learn.demo.algorithm.shangguigusorts;

import java.util.Arrays;

/**
 * 快速排序
 * 是对冒泡排序的改进
 * 思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小
 * 然后再按照此方法对这两部分数据分别进行快速排序，整个过程可以递归进行
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr2 = {72, 6, 57, 88, 60, 45, 456, 5354, 42, 83, 73, 48, 85};
        int arr1[] = {2,2,2,2,2,2,2};
        int arr[] = new int[8_000_0000];
        for (int i = 0; i < 8_000_0000; i++) {
            arr[i] = (int) (Math.random() * 8_000_0000);
        }
        long startTime = System.currentTimeMillis();
        quick_sort(arr2, 0, arr2.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("排序时间为：" + (endTime - startTime));
        System.out.println(Arrays.toString(arr2));
    }

    private static void quick_sort(int arr[], int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        //while 循环的目的是让比pivot小的放在左边   比pivot大的放在右边
        while (l < r) {
            //在pivot的左边 一直找，找到一个大于或者等于pivot的值才会退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot的左边 一直找，找到一个小于或者等于pivot的值才会退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果l>=r 说明 pivot的左右两的值 已经按照左边是小于等于pivot的值，右边大于等于pivot的值
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完成后发现这个arr[l]与pivot值相等
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换完成后发现这个arr[r]与pivot值相等
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }

        //向左递归
        if (r > left) {
            quick_sort(arr, left, r);
        }
        //向右递归
        if (l < right) {
            quick_sort(arr, l, right);
        }

    }
}
