package com.ym.learn.demo.algorithm.shangguigusorts;

/**
 * 希尔排序  移位式
 */
public class OptimizationShellSort {
    public static void main(String[] args) {
        int arr[] = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long startTime = System.currentTimeMillis();
        shell_sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序时间为：" + (endTime - startTime));
    }

    private static void shell_sort(int arr[]) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j-gap>= 0 && temp < arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while循环  就给temp找到了插入的位置
                    arr[j] = temp;
                }
            }
            gap /= 2;
        }
    }
}
