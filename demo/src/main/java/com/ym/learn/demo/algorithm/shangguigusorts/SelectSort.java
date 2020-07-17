package com.ym.learn.demo.algorithm.shangguigusorts;

/**
 * 2.选择排序  定义两个移动指针  一个指针指向数组开始的位置，另一个指针去寻找一个最小值  然后两个指针的值进行交换
 * 思路解法：
 * 1.先假定当前这个数是最小数
 * 2.然后和后面的每个数进行比较，如果发小更小的数  就重新确定最小数 并得到下标
 * 3.当遍历到数组的最后时就可以得到数组的最小数和下标
 * 4.进行交换
 * 选择排序 每次只进行一次的交换，相对于冒泡排序每次都需要进行交换，大大节省了时间
 */
public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1};
        int arr_new[] = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr_new[i] = (int) (Math.random() * 800000);
        }
        long startTime = System.currentTimeMillis();
        select_sort(arr_new);
        long endTime = System.currentTimeMillis();
        System.out.println("排序时间为：" + (endTime - startTime));
    }

    private static void select_sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//假定最小数的下标为0
            int min = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {//说明假定的最小值并不是最小
                    min = arr[j];//重置min
                    minIndex = j;//重置MinIndex
                }
            }
            //将最小值放在arr[i],即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
