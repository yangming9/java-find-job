package com.ym.learn.demo.algorithm;

/**
 * 动态规划算法
 * 思想：将大的问题分解为小的问题
 * 经过分解得到的子问题不是互相独立的
 * 某个子问题是需要依赖上一个问题的解的
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] w = {1,4,3};//物品的重量
        int[] val = {1500,3000,2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//物品的个数

        //为了记录放入商品的情况，定义一个二维数组
        int[][] path = new int[n+1][m+1];

        //创建二维数组
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n+1][m+1];

        //初始化第一行第一列，这里在本程序中，可以不去处理，因为默认就是0
        for (int i=0;i<v.length;i++){
            v[i][0] = 0;//将第一列设置为0
        }
        for (int i = 0;i<v[0].length;i++){
            v[0][i] = 0;
        }

//        //根据前面得到的公式进行动态规划处理
//        for (int i=1;i<v.length;i++){//不处理第一行 i是从1开始的
//            for (int j=1;j<v[0].length;j++){//不处理第一列  j是从1开始的
//                //公式
//                if (w[i-1] > j){
//                    v[i][j] = v[i-1][j];
//                }else {
//                    v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
//                }
//            }
//        }

        //根据前面得到的公式进行动态规划处理
        for (int i=1;i<v.length;i++){//不处理第一行 i是从1开始的
            for (int j=1;j<v[0].length;j++){//不处理第一列  j是从1开始的
                //公式
                if (w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else {
                    if (v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        for (int i = 0;i<v.length;i++){
            for (int j=0;j<v[i].length;j++){
                System.out.print(v[i][j]+ " ");
            }
            System.out.println();
        }

        //输出放入的商品
        int i = path.length-1; //path的行数
        int j = path[0].length-1; // 列的最大下标
        //应该是从path的最后开始找
        while (i>0 && j>0){
            if (path[i][j] == 1){
                System.out.printf("第%d个商品放入到背包中\n",i);
                j -=w[i-1];
            }
            i--;
        }
    }
}
