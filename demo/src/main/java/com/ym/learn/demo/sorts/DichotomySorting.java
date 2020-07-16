package com.ym.learn.demo.sorts;

/**
 * 二分查找
 */
public class DichotomySorting {

    private static int dichotomySorting(int arr[], int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid;
            }
        }

        return -1;
    }

    private static int dichotomySorting2(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }

    private static int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left+(right-left)/2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int target = 50;
        int arr[] = {1, 5, 6, 8, 9, 10, 12, 50, 50, 50, 80};
        System.out.println(left_bound(arr, target));
    }
}
