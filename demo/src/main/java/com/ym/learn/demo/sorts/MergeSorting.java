package com.ym.learn.demo.sorts;

/**
 * 归并排序
 */
public class MergeSorting {

    private int[] array;
    private int[] tempMergeArr;
    private int length;

    private static void printNumbers(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
        }
        System.out.println("\n");
    }

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergeArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergeArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        while (i <= middle && j <= higherIndex) {
            if (tempMergeArr[i] <= tempMergeArr[j]) {
                array[k] = tempMergeArr[i];
                i++;
            } else {
                array[k] = tempMergeArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergeArr[i];
            k++;
            i++;
        }
    }

    public static void main(String a[]) {
        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        MergeSorting mms = new MergeSorting();
        mms.sort(inputArr);
        printNumbers(inputArr);
    }
}
