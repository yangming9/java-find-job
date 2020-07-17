package com.ym.learn.demo.algorithm.sorts;

/**
 * 快速排序
 */
public class QuickSorting {

    private static void printNumbers(int[] input) {
        for (int j = 0; j < input.length; j++) {
            System.out.print(input[j] + ",");
        }
        System.out.println("\n");
    }

    private static void exchangeNumbers(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort(int lowerIndex, int higherIndex, int arr[]) {
        int i = lowerIndex;
        int j = higherIndex;
        int centralValue = arr[lowerIndex + (higherIndex - lowerIndex) / 2];
        while (i <= j) {
            while (arr[i] < centralValue) {
                i++;
            }
            while (arr[j] > centralValue) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, arr);
                i++;
                j--;
            }
        }
        //跳出循环说明i=j两个指针相遇
        if (i < higherIndex) {
            quickSort(i, higherIndex, arr);
        }
        if (j > lowerIndex) {
            quickSort(lowerIndex, j, arr);
        }

    }

    public static void main(String[] args) {
        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43,24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12,45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        Long start = System.currentTimeMillis();
        quickSort(0, input.length - 1, input);
        for (int i = 0;i<1000000000;i++){
            int a = 1;
        }
        Long time = System.currentTimeMillis()-start;
        System.out.println(time);
        printNumbers(input);
    }

}
