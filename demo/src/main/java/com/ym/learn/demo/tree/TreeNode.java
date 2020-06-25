package com.ym.learn.demo.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 二叉树前中后遍历  构建树 然后打印
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    static Queue<Integer> nodes = new ConcurrentLinkedQueue<>();

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private static void printAroundTree(TreeNode t) {
        if (t != null) {
            printAroundTree(t.left);
            nodes.offer(t.val);
            System.out.print(t.val + " ");
            printAroundTree(t.right);
        }
    }

//    private static void printAfterTree(TreeNode t) {
//        if (t != null) {
//            printAfterTree(t.left);
//            printAfterTree(t.right);
//            System.out.print(t.val + " ");
//        }
//    }

    private static void printAfterTree(TreeNode t) {
        Stack<TreeNode> nodes = new Stack<>();
        if (t != null){
            nodes.push(t);
        }
        while (t != null || !nodes.isEmpty()){
            TreeNode node = nodes.pop();
            if (node.left != null || node.right != null){
                nodes.push(node);
                if (node.left != null){
                    t = node.left;
                }
            }
        }
    }

        private static void printBeforeTree(TreeNode t){
        if(t!=null){
            System.out.print(t.val+" ");
            printBeforeTree(t.left);
            printBeforeTree(t.right);
        }
    }

//    /**
//     * 非递归方式  使用栈  前序遍历
//     * @param t
//     */
//    private static void printBeforeTree(TreeNode t) {
//        Stack<TreeNode> nodes = new Stack<>();
//        if (t != null){
//            nodes.push(t);
//        }
//        while (!nodes.isEmpty()){
//            TreeNode node = nodes.pop();
//            System.out.print(node.val+" ");
//            if (node.right != null){
//                nodes.push(node.right);
//            }
//            if (node.left != null){
//                nodes.push(node.left);
//            }
//        }
//    }


    public static void main(String[] args) {
        TreeNode e = new TreeNode(1);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(4);
        TreeNode m = new TreeNode(10);
        TreeNode n = new TreeNode(11);
        TreeNode g = new TreeNode(2, m, n);
        TreeNode d = new TreeNode(5, null, g);
        TreeNode f = new TreeNode(6, h, i);
        TreeNode b = new TreeNode(7, d, e);
        TreeNode c = new TreeNode(8, f, null);
        TreeNode root = new TreeNode(9, b, c);
        printAfterTree(root);
    }
}
