package com.ym.learn.demo.algorithm.hash;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        //创建hash表
        HashTab hashTab = new HashTab(7);
        //写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 查询雇员");
            System.out.println("exit: 添退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    default:
                        break;
            }
        }
    }

}
//创建hashtable 管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;

    private int size;//表示共有多少条链表

    public HashTab(int size) {
        this.size = size;
        //初始化链表
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0;i<size;i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        //根据员工id得到该员工应该加入到哪条链表
        int empLinkedListNo = hashFunc(emp.id);
        //将emp放入对应链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list(){
        for (int i = 0;i<size;i++){
            empLinkedListArray[i].list();
        }
    }

    //编写一个散列函数
    //使用一个简单的取模法
    public int hashFunc(int id){
        return id % size;
    }
}



//表示一个雇员
class Emp{
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int id;
    public String name;
    public Emp next;
}
//创建此类表示链表
class EmpLinkedList{
    //头指针，指向第一个Emp，因此我们这个链表的head，是直接指向第一个Emp
    private Emp head;//默认null

    //添加雇员
    //说明
    //1.假定添加雇员 id是自增长 id分配总是从小到大
    //因此我们将该雇员直接加入到本链表最后一个即可
    public void add(Emp emp){
        //如果是添加第一个雇员
        if (head == null){
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针 帮助定位到最后
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(){
        if (head == null){//链表为空
            System.out.println("当前链表为空！");
            return;
        }
        System.out.println("当前链表信息为：");
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id = %d name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println("");
    }
}
