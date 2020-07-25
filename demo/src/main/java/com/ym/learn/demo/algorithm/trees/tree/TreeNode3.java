package com.ym.learn.demo.algorithm.trees.tree;

import java.util.*;

public class TreeNode3 {

    private static List<Integer> preorderTree(TreeNode treeNode) {
        List<Integer> preorderResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = treeNode;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                preorderResult.add(currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
        return preorderResult;
    }

    private static List<Integer> inorderTree(TreeNode root) {
        List<Integer> preorderResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                preorderResult.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        return preorderResult;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    private static List<Integer> afterorderTree(TreeNode root) {
        List<Integer> preorderResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                preorderResult.add(currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.right;
            }

            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                currentNode = currentNode.left;
            }
        }
        Collections.reverse(preorderResult);
        return preorderResult;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    private static List<Integer> levelOrderTree(TreeNode root){
        List<Integer> levelResult = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null){
            return levelResult;
        }
        deque.addLast(root);
        TreeNode currentNode = root;
        while (!deque.isEmpty()){
            currentNode = deque.pollFirst();
            if (currentNode.left != null){
                deque.addLast(currentNode.left);
            }
            if (currentNode.right != null){
                deque.addLast(currentNode.right);
            }
            levelResult.add(currentNode.val);
        }
        return levelResult;
    }


    public static void main(String[] args) {
        TreeNode e = new TreeNode(1);
        TreeNode m = new TreeNode(10);
        TreeNode n = new TreeNode(11);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(4);
        TreeNode g = new TreeNode(2, m, n);
        TreeNode d = new TreeNode(5, null, g);
        TreeNode f = new TreeNode(6, h, i);
        TreeNode b = new TreeNode(7, d, e);
        TreeNode c = new TreeNode(8, f, null);
        TreeNode root = new TreeNode(9, b, c);
        for (Integer val : preorderTree(root)) {
            System.out.print(val + " ");
        }
    }
}
