package com.ym.learn.demo.math;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSorting {

    private static void printNumbers(int i, int[] input) {
        System.out.print("第" + (i + 1) + "次循环结果： ");
        for (int j = 0; j < input.length; j++) {
            System.out.print(input[j] + ",");
        }
        System.out.println("\n");
    }

    private static void select_sort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;//记录最小数的下标
                }
            }
            if (index != i) {
                int smallerNumber = array[index];
                array[index] = array[i];
                array[i] = smallerNumber;
            }

            printNumbers(i, array);
        }
    }

    public static void selectSort(int[] arr) {

        if (arr == null)
            return;
        int len = arr.length;
        //i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
        for (int i = 0; i < len - 1; i++) {
            //minIndex 用来保存每次比较后较小数的下标。
            int minIndex = i;
            //j控制比较次数，因为每次循环结束之后最小的数都已经放在了最前面，
            //所以下一次循环的时候就可以跳过这个数，所以j的初始值为i+1而不需要每次循环都从0开始，并且j<len即可
            for (int j = i + 1; j < len; j++) {
                //每比较一次都需要将较小数的下标记录下来
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            //当完成一次循环时，就需要将本次循环选取的最小数移动到本次循环开始的位置。
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            //打印每次循环结束之后数组的排序状态（方便理解）
            System.out.println("第" + (i + 1) + "次循环之后效果：" + Arrays.toString(arr));
        }
    }

    private static void selectSorting(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                int smallerNum = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = smallerNum;
            }
            printNumbers(i,arr);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};
        int[] arr2 = {5, 1, 12, -5, 16, 2, 12, 14};
//        select_sort(arr2);
//        selectSort(arr2);
        selectSorting(arr2);
    }

}
