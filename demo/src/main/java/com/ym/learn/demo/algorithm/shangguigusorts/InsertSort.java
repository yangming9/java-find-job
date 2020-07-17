package com.ym.learn.demo.algorithm.shangguigusorts;

/**
 * 插入排序
 * 排序思想：
 *     将n个待排序的元素看成为一个有序表和一个无序表，开始时有序表只包含一个元素，无序表中包含有n-1个元素
 *     排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置
 *     使之成为新的有序表
 */
public class InsertSort {

    public static void main(String[] args) {
        //创建一个8万个随机的数组
        int arr_new[] = new int[80000];
        for (int i = 0;i<80000;i++){
            arr_new[i] = (int)(Math.random()*80000);
        }
        long startTime = System.currentTimeMillis();
        insert_sort(arr_new);
        long endTime = System.currentTimeMillis();
        System.out.println("排序时间为："+(endTime-startTime));
    }


    private static void insert_sort(int arr[]) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 0;i<arr.length-1;i++){
            insertVal = arr[i+1];//定义待插入的数
            insertIndex = i ;//即arr[1]的前面这个数的下标
            //给insertVal找到插入的位置
            //1.insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            //2.insertVal < arr[insertIndex] 待插入的数还没有找到插入的位置
            //3.就需要将arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //退出while循环时，说明找到了插入位置，insertIndex +1
            arr[insertIndex+1] = insertVal;
        }

    }
}
