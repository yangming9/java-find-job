package com.ym.learn.demo.algorithm.shangguigusorts;

/**
 * 希尔排序  本类中的代码插入采用的是交换法
 * 是简单插入排序的优化版本，简单插入排序如果最小的数在最后面 那么会造成移动数量很多，排序效率就会下降
 * 也称为缩小增量排序
 * 排序思想：把记录按照下标的一定增量分组，对每组使用直接插入排序算法排序
 * 随着增量逐渐减少，每组包含的关键词越来越少，直到增量变为1
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long startTime = System.currentTimeMillis();
        shell_sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序时间为：" + (endTime - startTime));
    }

    private static void shell_sort(int arr[]) {
        int temp = 0;
        int length = arr.length;
        int gap = length/2;
        while (gap > 0){
            for (int i = gap; i < arr.length; i++) {
                //循环遍历每组的数据，（共五组  每个步长为5）
                //插入采用的是交换法
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            gap = gap/2;
        }

    }
}
