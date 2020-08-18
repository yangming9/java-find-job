package com.ym.learn.demo.algorithm.find;

/**
 * 二分查找的升级版本：
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class BinarySearchImprove {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(binary_search_improve(8, nums));
    }

    private static int binary_search_improve(int target,int[] nums){
        int left = 0;
        int right = nums.length-1;
        int privot = 0;
        while (left<=right){
            privot = (left+right)/2;//中间值的index
            if (target == nums[privot]){
                return privot;
            }
            //判断中间坐标两侧的哪一边是有序的序列，从有序序列的一侧入手
            if (nums[left] <= nums[privot]){//如果成立说明左侧是有序的序列
                //下面的if判断说明target在这个范围
                if (nums[left] < target && target <= nums[privot]){
                    right = privot-1;
                }else {//说明是在另外一侧
                    left = privot +1;
                }
            }else {//如果成立说明右侧是有序的序列
                if (target > nums[privot] && target <= nums[right]){
                    left = privot +1;
                }else {
                    right = privot - 1;
                }
            }
        }
        return -1;
    }
}
