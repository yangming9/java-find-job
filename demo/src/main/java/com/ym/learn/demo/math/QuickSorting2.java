package com.ym.learn.demo.math;

/**
 * 快速排序第二种思路
 */
public class QuickSorting2 {

    private static void printNumbers(int[] input) {
        for (int j = 0; j < input.length; j++) {
            System.out.print(input[j] + ",");
        }
        System.out.println("\n");
    }

    /**
     * 排序过程
     *
     * @param arr   待排序数组
     * @param left  待排序数组最小下标
     * @param right 待排序数组最大下标
     * @return 排好序之后基准数的位置下标，方便下次的分区
     */
    private static int qSort(int arr[], int left, int right) {
        //https://www.toutiao.com/a6677701810796364300/
        int temp = arr[left];
        //定义基准数，默认为待排序数组的第一个数
        while (left < right) {
            while (left < right && arr[right] > temp) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            while (left < right && arr[left] < temp) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }// 循环执行的条件
        arr[left] = temp;
        return left;
        //因为默认的基准数是在最左边，所以首先从右边开始比较进入while循环的判断条件
        //如果当前arr[right]比基准数大，则直接将右指针左移一位，当然还要保证left<right
        //跳出循环说明当前的arr[right]比基准数要小，那么直接将当前数移动到基准数所在的位置，并且左指针向右移一位(left++)
        //这时当前数(arr[right])所在的位置空出，需要从左边找一个比基准数大的数来填充
        //下面的步骤是为了在左边找到比基准数大的数填充到right的位置。
        //因为现在需要填充的位置在右边，所以左边的指针移动，如果arr[left]小于或者等于基准数，则直接将左指针右移一位
        //跳出上一个循环说明当前的arr[left]的值大于基准数，需要将该值填充到右边空出的位置，然后当前位置空出。
        //当循环结束说明左指针和右指针已经相遇。并且相遇的位置是一个空出的位置，
        //这时候将基准数填入该位置，并返回该位置的下标，为分区做准备。
    }

    /**
     * 分区过程
     *
     * @param arr   带分区数组
     * @param left  带分区最小下标
     * @param right 待分组数组最大下标
     */
    private static void quickSorting(int[] arr, int left, int right) {
        if (left<right){
            int temp = qSort(arr,left,right);
            quickSorting(arr,temp+1,right);
            quickSorting(arr,left,temp-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {72, 6, 57, 88, 60, 45, 456, 5354, 42, 83, 73, 48, 85};
        quickSorting(arr, 0, arr.length - 1);
        printNumbers(arr);
    }

}
