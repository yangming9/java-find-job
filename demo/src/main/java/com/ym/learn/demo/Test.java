package com.ym.learn.demo;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode node = new TreeNode(5);
//        TreeNode treeNode = new TreeNode(11);
//        TreeNode treeNode1 = new TreeNode(7);
//        TreeNode treeNode2 = new TreeNode(6);
//        treeNode2.left = node;
//        treeNode2.right = treeNode;
//        TreeNode treeNode7 = new TreeNode(10);
//        TreeNode treeNode3 = new TreeNode(8);
//        treeNode3.left = treeNode2;
//        treeNode3.right = treeNode7;
//        TreeNode treeNode8 = new TreeNode(12);
//        TreeNode treeNode4 = new TreeNode(9);
//        treeNode4.right = treeNode3;
//        treeNode4.left = treeNode8;
//        TreeNode treeNode5 = new TreeNode(4);
//        treeNode5.left = treeNode3;
//        treeNode5.right = treeNode4;
//        TreeNode treeNode9 = new TreeNode(13);
//        TreeNode treeNode6 = new TreeNode(6);
//        treeNode6.left = treeNode1;
//        treeNode6.right = treeNode9;
//        root.left = treeNode5;
//        root.right = treeNode2;
//        System.out.println(isBalanced(root));

        int[] arr = {-10,-3,0,5,9};
        sortedArrayToBST(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 标记，默认树是平衡的（比如空树）
    static boolean flag = true;
    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }
    //中序遍历的方式，选取数列的中点作为根结点
    private static TreeNode dfs(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid-1);
        root.right = dfs(nums, mid+1, right);
        return root;
    }

    public static boolean isBalanced(TreeNode root) {
        // dfs 后序遍历判断是否不平衡
        dfs(root);
        return flag;
    }
    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 左右子树最深深度
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;

        // AVL树 —— 平衡因子：当 左子树深度 - 右子树深度的绝对值 > 1 时
        // 需要进行LL、RR、LR、RL旋转让其恢复平衡，这也是为什么我们最后
        // 选择返回左右子树中最深的深度。因为平衡因子受到其制约。
        // AVL树中的平衡因子可为 -1，0，1，又因为我们需要得到左右子树深度
        // 后才能计算平衡因子，理所当然地选择后序遍历（左右根）去 get 答案~
        // 还是不太理解的话，建议去学习一下数据结构 —— BST、AVL这两部分
        if (Math.abs(left - right) > 1) {
            flag = false;
        }

        return Math.max(left, right);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

