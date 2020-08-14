package com.ym.learn.demo.algorithm.find;

import java.util.Arrays;

/**
 * 斐波那契查找  使用的前提数组是有序的数列
 * 斐波那契数列：1，1，2，3，5，8，13，21，34，55。。。。
 * 斐波那契数列的两个相邻的数的比例无限接近于黄金分割比例
 * 与二分查找和插值查找相比也是改变了mid的位置 mid不再是中间或者插值得到
 * 公式：mid = left+F(k-1)-1
 * F代表斐波那契数列  k代表的是斐波那契的第几个元素
 * F(k) = F(k-1)+F(k-2)
 * F(k)-1 = (F(k-1)-1)+(F(k-2)-1)+1
 * 数组的长度有可能不满足 n=F(k)-1 需要将原来数组的长度增加至符合条件
 */
public class FibonacciSearch {
    private static int maxSize = 20;
    public static void main(String[] args) {
        int arr[] = {1,8,10,89,1000,1234};
        System.out.println(fibonacci_search(arr, 1001));
    }
    //因为后面我们mid=low+F（k-1）-1 需要用到斐波那契数列 因此我们需要先获取到一个斐波那契数列
    //非递归方法得到一个斐波那契数列

    /**
     * 构建斐波那契数列
     * @return
     */
    private static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2;i<maxSize;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }

    /**
     * 使用非递归方式进行编写
     * @param arr  数组
     * @param key  我们需要查找的关键码（值）
     * @return  返回对应的下标
     */
    private static int fibonacci_search(int arr[],int key){
        int low = 0;
        int high = arr.length-1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;//存放mid值
        int f[] = fib();//获取到斐波那契数列
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1){
            k++;
        }
        //因为f[k]值可能大于arr的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向arr
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr,f[k]);
        //实际上需求使用arr数组最后的数填充temp
        //这个for循环的作用是：
        //temp={1,8,10,89,1000,1234,0,0,0} => {1,8,10,89,1000,1234,1234,1234,1234}
        for (int i = high+1;i<temp.length;i++){
            temp[i] = arr[high];
        }
        //使用while循环处理，找到我们的数key
        while (low<=high){
            mid = low+f[k-1]-1;
            if (key<temp[mid]){//我们应该继续向数组的前面查找（左边）
                high = mid -1;
                //说明：1.全部元素 = 前面的元素 + 后边的元素
                //2.f[k]=f[k-1]+f[k-2]
                //因为前面有f[k-1]个元素，所以可以继续拆分 f[k-1]=f[k-2]+f[k-3]
                //即在f[k-1]的前面继续查找 k--
                //即下次循环的时候 mid = f[k-1-1] -1
                k--;//为什么需要k--
            }else if (key > temp[mid]){
                low = mid+1;
                k -=2;
                //为什么是k-2
                //说明：
                //1.全部元素 = 前面的元素 + 后面的元素
                //2.f[k]=f[k-1]+f[k-2]
                //3.因为前面有f[k-2]个元素，所以可以继续拆分 f[k-1]=f[k-3]+f[k-4]
                //4.即在f[k-2]的前面进行查找 k-=2
                //5.即下次循环 mid = f[k-1-2]-1
            }else {
                //需要确定返回的是哪个下标
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
