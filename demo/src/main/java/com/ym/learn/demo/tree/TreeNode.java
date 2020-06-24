package com.ym.learn.demo.tree;

/**
 * 二叉树前中后遍历  构建树 然后打印
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    private TreeNode(int val) {
        this.val = val;
    }

    private TreeNode(int val, TreeNode left, TreeNode right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private static void printAroundTree(TreeNode t){
        if(t!=null){
            printAroundTree(t.left);
            System.out.print(t.val+" ");
            printAroundTree(t.right);
        }
    }

    private static void printAfterTree(TreeNode t){
        if(t!=null){
            printAfterTree(t.left);
            printAfterTree(t.right);
            System.out.print(t.val+" ");
        }
    }

    private static void printBeforeTree(TreeNode t){
        if(t!=null){
            System.out.print(t.val+" ");
            printBeforeTree(t.left);
            printBeforeTree(t.right);
        }
    }

    public static void main(String[] args) {
        TreeNode e = new TreeNode(1);
        TreeNode g = new TreeNode(2);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(4);
        TreeNode d = new TreeNode(5,null,g);
        TreeNode f = new TreeNode(6,h,i);
        TreeNode b = new TreeNode(7,d,e);
        TreeNode c = new TreeNode(8,f,null);
        TreeNode root = new TreeNode(9,b,c);
        printAroundTree(root);
        printAfterTree(root);
        printBeforeTree(root);
    }
}
