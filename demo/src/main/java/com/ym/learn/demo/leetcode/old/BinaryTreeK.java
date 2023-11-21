package com.ym.learn.demo.leetcode.old;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树第K层元素的个数
 */
public class BinaryTreeK {
    public static void main(String[] args) {
        Node root = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        root.left = node4;
        root.right = node1;
        node4.left = node2;
        node4.right = node3;

        System.out.println(getKNodeNum(root, 4));

    }

    private static int getKNodeNum(Node root,int k){
        if(root == null)
            return -1;

        Queue<Node> queue = new LinkedList<>();

        int size = 0;

        int count = 1;

        queue.offer(root);

        while (!queue.isEmpty()){

            size = queue.size();

            if (count == k){
                return size;
            }

            while (size>0){

                Node node = queue.poll();

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }

            count++;

        }

        return -1;
    }

}
class Node{
    public int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}
