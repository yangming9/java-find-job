package com.ym.learn.demo.math;

/**
 * 插入排序
 */
public class InsertSorting {
    private static void printNumbers(int i, int[] input) {
        System.out.print("第" + i + "次循环结果： ");
        for (int j = 0; j < input.length; j++) {
            System.out.print(input[j] + ",");
        }
        System.out.println("\n");
    }

    private static void insertSorting(int arr[]){
        //假设数组第一个数字是默认正确的排序的数组
        //因此是从数组的第二个数字开始进行插入，直到将所有的数字插入完毕
        for (int i = 1;i<arr.length;i++){
            for (int j = i;j>0;j--){
                if (arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            printNumbers(i,arr);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {10,34,2,56,7,67,88,42};
        insertSorting(arr1);
    }
}
