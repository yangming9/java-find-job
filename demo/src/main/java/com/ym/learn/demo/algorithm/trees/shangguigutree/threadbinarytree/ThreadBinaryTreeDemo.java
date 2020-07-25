package com.ym.learn.demo.algorithm.trees.shangguigutree.threadbinarytree;
//线索化二叉树
//前驱   后继
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {

    }
}

//定义一个ThreadBinaryTree 二叉树
class BinaryTree {

    private HeroNode root;

    //为了实现线索化  需要创建要给指向当前节点的前驱结点的指针
    private HeroNode pre = null;//递归进行线索化  总是保留前一个节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 编写二叉树进行中序线索化方法
     * @param node  当前需要线索化的节点
     */
    public void threadNodes(HeroNode node){
        if (node == null){//如果node == null  不能线索化
            return;
        }
        //先线索化左子树
        threadNodes(node.getLeft());
        //线索化当前节点
        //暂时跳过
        //线索化右子树
        threadNodes(node.getRight());
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    /**
     * 如果leftType==0 表示指向左子树  如果 1 表示指向前驱结点
     * 如果rightTypr==0 表示指向右子树  如果 1 表示指向后继结点
     */
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}