package com.ym.learn.demo.algorithm.trees.tree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TreeNode2 {

    static List<Integer> vals = new ArrayList<>();

    static Queue<Integer> nodes = new ConcurrentLinkedQueue<>();

    public static List<Integer> getVals() {
        return vals;
    }

    /**
     * 采用list方式进行打印  前序遍历
     * 递归的方式
     */
    private static List<Integer> preorderRecursionTraversal(TreeNode root) {

        List<Integer> vals = getVals();

        if (root != null) {
            vals.add(root.val);
            if (root.left != null) {
                preorderRecursionTraversal(root.left);
            }
            if (root.right != null) {
                preorderRecursionTraversal(root.right);
            }
        }

        return vals;
    }

    /**
     * 非递归方式 前序遍历  使用栈的方式
     *
     * @param root
     * @return
     */
    private static List<Integer> preorderNotRecursionTraversal(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        if (root != null) {
            nodes.push(root);
        }
        while (!nodes.isEmpty()) {
            //获取头部元素，并且移除
            TreeNode node = nodes.pop();
            vals.add(node.val);
            if (node.right != null) {
                nodes.push(node.right);
            }
            if (node.left != null) {
                nodes.push(node.left);
            }
        }
        return vals;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    private static List<Integer> inorderNotRecursionTraversal(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();

        while (root != null || !nodes.isEmpty()){
            while (root != null){
                nodes.push(root);
                root = root.left;
            }

            root = nodes.pop();
            vals.add(root.val);
            root = root.right;
        }
        return vals;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    private static List<Integer> afterorderNotRecursionTraversal(TreeNode root) {

        if (root != null){
            afterorderNotRecursionTraversal(root.left);
            afterorderNotRecursionTraversal(root.right);
            vals.add(root.val);
        }
        return vals;
    }



    /**
     * 非递归方式 前序遍历  使用队列方式
     *
     * @param root
     * @return
     */
    private static Queue<Integer> preorderNotRecursionTraversalWithQueue(TreeNode root) {

        if (root != null) {
            nodes.offer(root.val);
            if (root.left != null) {
                preorderNotRecursionTraversalWithQueue(root.left);
            }
            if (root.right != null) {
                preorderNotRecursionTraversalWithQueue(root.right);
            }
        }
        return nodes;
    }


    public static void main(String[] args) {
        TreeNode e = new TreeNode(1);
        TreeNode m = new TreeNode(10);
        TreeNode n = new TreeNode(11);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(4);
        TreeNode g = new TreeNode(2,m,n);
        TreeNode d = new TreeNode(5, null, g);
        TreeNode f = new TreeNode(6, h, i);
        TreeNode b = new TreeNode(7, d, e);
        TreeNode c = new TreeNode(8, f, null);
        TreeNode root = new TreeNode(9, b, c);
//        preorderRecursionTraversal(root);
//        preorderNotRecursionTraversal(root);
//        preorderNotRecursionTraversalWithQueue(root);
        inorderNotRecursionTraversal(root);
//        afterorderNotRecursionTraversal(root);
        for (Integer val : vals) {
            System.out.print(val);
        }
        System.out.println("\n");
//        for (Integer val : nodes) {
//            System.out.print(val);
//        }
//        System.out.println("\n");
    }
}
