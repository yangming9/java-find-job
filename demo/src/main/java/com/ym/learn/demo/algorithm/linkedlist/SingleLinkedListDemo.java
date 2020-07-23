package com.ym.learn.demo.algorithm.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1, "test1", "q");
        HeroNode heroNode1 = new HeroNode(2, "test2", "w");
        HeroNode heroNode2 = new HeroNode(3, "test3", "e");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode);
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.list();
        singleLinkedList.addByOrder(new HeroNode(4, "test4", "r"));
        System.out.println("------按照顺序插入后------");
        singleLinkedList.list();
        System.out.println("------修改链表指定位置的内容-------");
        HeroNode node = new HeroNode(3, "test111111", "t");
        singleLinkedList.update(node);
        singleLinkedList.list();
        System.out.println("-------删除指定节点-------");
        singleLinkedList.delNode(5);
        singleLinkedList.list();
        System.out.println("链表的节点个数为：" + getLinkedListLength(singleLinkedList.getHead()));
        System.out.println(getHeroNodeByIndex(singleLinkedList.getHead(), 2).toString());
        System.out.println("-----链表反转-----");
        reverseLinkedList(singleLinkedList);
        singleLinkedList.list();
        System.out.println("利用栈反序打印所有的链表");
        reversePrintByStack(singleLinkedList);
    }


    /**
     * 反序打印
     *
     * @param singleLinkedList
     */
    public static void reversePrintByStack(SingleLinkedList singleLinkedList) {
        HeroNode head = singleLinkedList.getHead();
        if (head.next == null){
            return;
        }
        Stack<HeroNode> nodeStack = new Stack<>();

        HeroNode cur = head.next;

        //将链表所有节点 压入栈中
        while (cur != null){
            nodeStack.push(cur);
            cur = cur.next;
        }

        while (!nodeStack.isEmpty()){
            HeroNode temp = nodeStack.peek();
            System.out.println(temp);
            nodeStack.pop();
        }
    }

    /**
     * 反转单链表
     */
    public static void reverseLinkedList(SingleLinkedList singleLinkedList) {
        HeroNode head = singleLinkedList.getHead();
        //链表为空或只有一个节点无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义辅助指针 遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点

        HeroNode reverseHead = new HeroNode(0, "", "");

        while (cur != null) {
            next = cur.next;//暂时保存当前节点的下一个节点
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        head.next = reverseHead.next;
    }

    /**
     * 查找单链表中 倒数第k个节点
     * 思路
     * 1.编写一个方法接收head节点 同时接收一个index
     * 2.index表示倒数第index个节点
     * 3.先将链表遍历 得到链表总长度
     * 4.得到size后，从链表第一个开始遍历（size-index）ge 就可以得到
     *
     * @param head
     * @param index
     * @return
     */
    public static HeroNode getHeroNodeByIndex(HeroNode head, int index) {
        if (head.next == null || index < 0) {
            return null;
        }

        int length = getLinkedListLength(head);

        if (index > length) {
            return null;
        }

        HeroNode cur = head.next;
        int i = 0;
        while (i < length - index) {
            cur = cur.next;
            i++;
        }
        return cur;

    }

    /**
     * 面试题目  查找链表中节点的个数  不包括头结点
     *
     * @param head
     * @return
     */
    public static int getLinkedListLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}


//定义一个SingleLinkedList管理我们的英雄
class SingleLinkedList {
    //初始化一个头结点   头结点一般不要动
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //不考虑编号顺序
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode node) {
        //head节点不能动 需要一个辅助指针
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //根据数据顺序 将数据插入到指定的位置
    public void addByOrder(HeroNode node) {
        //因为头结点不能动，因此仍然通过辅助指针 变量 来帮助找到添加的位置
        //因此temp是位于插入位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;//标识添加的编号是否存在，默认false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > node.no) {//说明位置找到 就在temp
                break;
            } else if (temp.next.no == node.no) {
                flag = true;//说明编号存在
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备插入的数据已经存在");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 找到需要删除的节点的上一个节点
     * 被删除的节点 不会存在其他引用 会被垃圾回收机制回收
     *
     * @param no
     */
    public void delNode(int no) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }

        HeroNode temp = head;

        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("需要删除的节点不存在 no=" + no);
        }

    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    //根据newHeroNode 的no 来修改即可
    public void update(HeroNode node) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;

        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;//说明链表遍历完成
            }
            if (temp.no == node.no) {
                flag = true;
                break;//说明找到节点
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else {
            System.out.println("没有找到编号为：" + node.no + "的节点");
        }
    }

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("======链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//定义HeroNode 每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
