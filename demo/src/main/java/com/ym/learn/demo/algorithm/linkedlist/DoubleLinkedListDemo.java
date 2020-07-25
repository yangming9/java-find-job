package com.ym.learn.demo.algorithm.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode = new HeroNode2(1, "test1", "q");
        HeroNode2 heroNode1 = new HeroNode2(2, "test2", "w");
        HeroNode2 heroNode2 = new HeroNode2(5, "test3", "e");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode);
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.list();
        HeroNode2 node2 = new HeroNode2(2, "test4", "r");
        doubleLinkedList.addByOrder(node2);
        System.out.println("------按照顺序插入后------");
        doubleLinkedList.list();
        System.out.println("------修改链表指定位置的内容-------");
        HeroNode2 node = new HeroNode2(3, "test111111", "t");
        doubleLinkedList.update(node);
        doubleLinkedList.list();
        System.out.println("-------删除指定节点-------");
        doubleLinkedList.delNode(5);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    //初始化一个头结点   头结点一般不要动
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //根据数据顺序 将数据插入到指定的位置
    public void addByOrder(HeroNode2 node) {
        //因为头结点不能动，因此仍然通过辅助指针 变量 来帮助找到添加的位置
        //因此temp是位于插入位置的前一个节点
        HeroNode2 temp = head;
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
            if (temp.next == null){
                temp.next = node;
                node.pre = temp;
            }else {
                node.next = temp.next;
                node.pre = temp.next.pre;
                temp.next = node;
                node.next.pre = node;
            }
        }
    }

    //对于双向链表可以找到要删除的节点自身进行删除
    public void delNode(int no) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }

        HeroNode2 temp = head.next;

        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //这里代码有问题
            if (temp.next !=null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("需要删除的节点不存在 no=" + no);
        }

    }

    public void update(HeroNode2 node) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode2 temp = head.next;

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

    /**
     * 添加节点
     * @param node
     */
    public void add(HeroNode2 node) {
        //head节点不能动 需要一个辅助指针
        HeroNode2 temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("======链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
