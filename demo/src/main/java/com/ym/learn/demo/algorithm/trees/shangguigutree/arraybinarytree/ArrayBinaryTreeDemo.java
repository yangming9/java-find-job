package com.ym.learn.demo.algorithm.trees.shangguigutree.arraybinarytree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.infixOrder();

    }
}
//编写一个arraybinarytree 实现二叉树的顺序存储
class ArrayBinaryTree{
    private int arr[];//存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载前序遍历
    public void preOrder(){
        preOrder(0);
    }

    //编写一个方法，完成顺序存储的二叉树的前序遍历
    public void preOrder(int index){
        //如果数组为空  或者  arr.length = 0
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能进行二叉树前序遍历");
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index*2+1)<arr.length){
            preOrder(index*2+1);
        }
        //向右递归遍历
        if ((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }

    public  void infixOrder(){
        infixOrder(0);
    }

    public void infixOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空不能进行中序遍历");
        }

        if ((index*2+1)<arr.length){
            infixOrder(index*2+1);
        }

        System.out.println(arr[index]);

        if ((index*2+2)<arr.length){
            infixOrder(index*2+2);
        }
    }
}
