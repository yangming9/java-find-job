package com.ym.learn.demo.algorithm.shangguigusorts;

/**
 * 优化冒泡排序
 * 如果一趟比较下来没有进行过交换 说明序列有序 因此在排序过程中设置一个flag标志位
 * 判断元素是否进行过排序
 * 减少不必要的排序
 */
public class OptimizationBubbleSort {

    public static void main(String[] args) {
        int arr[] = {5, 1, 12,5, 1, 12, -5, 16, -5, 16};
        //创建一个8万个随机的数组
        int arr_new[] = new int[80000];
        for (int i = 0;i<80000;i++){
            arr_new[i] = (int)(Math.random()*80000);
        }
        long startTime = System.currentTimeMillis();
        bubble_sort(arr_new);
        long endTime = System.currentTimeMillis();
        System.out.println("排序时间为："+(endTime-startTime));
    }

    private static void bubble_sort(int arr[]) {
        /**
         * 第一趟排序就是将最大的数排在最后面
         * 第二趟排序就是将第二大的数排在倒数第二大的位置
         * 第n次就是将数据第n大数据放置相应的位置
         */
        int temp = 0;//临时变量
        boolean flag = false;//表示变量，表示是否进行过交换
        for (int i= 0; i <arr.length-1;i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序结果："+ Arrays.toString(arr));
            if (!flag){ //在一趟排序中一次交换都没有发生过
                break;
            }else {
                flag = false;//重置flag，进行下次判断
            }
        }
    }
}
