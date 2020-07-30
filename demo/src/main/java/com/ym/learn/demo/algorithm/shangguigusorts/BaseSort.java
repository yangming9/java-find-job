package com.ym.learn.demo.algorithm.shangguigusorts;

import java.util.Arrays;

/**
 * 基数排序  效率高稳定性排序
 * 基数排序是桶排序的扩展
 * 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。
 * 然后从最低位开始，依次进行排序。这样从最低位排序一直到最高位排序完成后，就变成一个有序序列
 */
public class BaseSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        base_sort(arr);
        System.out.println("" + Arrays.toString(arr));
        int n = 2;
        String start = "1";
        start.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<1;i++){
            int temp = 0;
            sb.append(n);
        }
        System.out.println(sb.toString());
    }

    /**
     * 第一轮
     * 1.将每个元素的个位数取出，然后看这个数应该放在哪个对应的桶（一个一维数组）
     * 2.按照这个 桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
     * 第二轮
     * 1.将每个元素的十位数取出，然后看这个数应该放在哪个对应的桶（一个一维数组）
     * 2.按照这个 桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
     */
    public static void base_sort(int arr[]) {
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //得到最大的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大的数的长度
        int maxLength = (max+"").length();

        /**
         * 说明
         * 1.二维数组包含10个一维数组
         * 2.为了防止在放入数的时候，数据溢出，则每一个一维数组（桶）大小定为arr.length
         * 3.基数排序是使用空间换时间的经典算法
         */
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据，定义一个一维数组来记录各个桶的每次放入数据的个数
        //可以理解为：bucketElementCounts[0]记录的就是bucket[0]的放入的数据的个数，其他以此类推
        int[] bucketElementCounts = new int[10];

        for (int i=0,n=1;i<maxLength;i++,n*=10){
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的各位
                int digitOfElement = (arr[j]/n)% 10;
                //放入对应的桶
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //按照桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
            int index = 0;
            //遍历每一桶，并将桶中的数据，放入到原来的数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶第k个桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入原来的数组
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }


    }
}
