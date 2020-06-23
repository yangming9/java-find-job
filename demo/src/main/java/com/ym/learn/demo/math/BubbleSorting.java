package com.ym.learn.demo.math;

/**
 * 冒泡排序
 */
public class BubbleSorting {

    private static void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printNumbers(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
        }
        System.out.println("\n");
    }

    private static void bubble_sort(int array[]) {
        int n = array.length;
        int k;
        for (int m = n; m > 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }
            printNumbers(array);
        }
    }

    public static void main(String[] args) {
        int[] input1 = {5, 1, 12, -5, 16};
//        int[] input2 = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        bubble_sort(input1);
//        bubble_sort(input2);
    }
}
