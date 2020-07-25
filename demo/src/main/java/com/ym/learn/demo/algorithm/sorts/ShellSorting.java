package com.ym.learn.demo.algorithm.sorts;

/**
 * 希尔排序
 */
public class ShellSorting {
    private static void printNumbers(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
        }
        System.out.println("\n");
    }

    private static void shell_sort(int[] arr) {
        if (arr == null) {
            return;
        }
        int length = arr.length;//数组长度
        int k = length / 2;//初始的增量为数组长度的一半
        //while循环控制按增量的值来划不同分子序列，每完成一次增量就减少为原来的一半
        //增量的最小值为1，即最后一次对整个数组做直接插入排序
        while (k > 0) {
            //里面其实就是升级版的直接插入排序了，是对每一个子序列进行直接插入排序
            //所以直接将直接插入排序中的1变为k就可以了
            for (int i = k; i < length; i++) {
//                int j = i;
                int target = arr[i];
                while (i >= k && target < arr[i - k]) {
                    arr[i] = arr[i - k];
                    i -= k;
                }

                arr[i] = target;
            }
            printNumbers(arr);
            k/=2;
        }
    }

    public static void main(String[] args) {
        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        shell_sort(inputArr);
    }
}
