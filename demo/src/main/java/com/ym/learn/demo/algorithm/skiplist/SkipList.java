package com.ym.learn.demo.algorithm.skiplist;

import java.util.Random;

class SkipListNode {
    int value;
    SkipListNode[] forward;

    public SkipListNode(int value, int level) {
        this.value = value;
        this.forward = new SkipListNode[level + 1];
    }
}

public class SkipList {
    private static final int MAX_LEVEL = 3;
    private SkipListNode head;
    private int level;
    private Random random;

    public SkipList() {
        this.head = new SkipListNode(-1, MAX_LEVEL); // -1 as a sentinel value
        this.level = 0;
        this.random = new Random();
    }

    private int randomLevel() {
        int lvl = 0;
        while (lvl < MAX_LEVEL && random.nextInt(2) == 1) {
            lvl++;
        }
        return lvl;
    }

    public void insert(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode x = head;
        for (int i = level; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].value < value) {
                x = x.forward[i];
            }
            update[i] = x;
        }
        int newLevel = randomLevel();
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }
        SkipListNode newNode = new SkipListNode(value, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public void delete(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode x = head;
        for (int i = level; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].value < value) {
                x = x.forward[i];
            }
            update[i] = x;
        }
        x = x.forward[0];
        if (x != null && x.value == value) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != x) break;
                update[i].forward[i] = x.forward[i];
            }
            while (level > 0 && head.forward[level] == null) {
                level--;
            }
        }
    }

    public boolean search(int value) {
        SkipListNode x = head;
        for (int i = level; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].value < value) {
                x = x.forward[i];
            }
        }
        x = x.forward[0];
        return x != null && x.value == value;
    }

    public void printList() {
        for (int i = 0; i <= level; i++) {
            SkipListNode node = head.forward[i];
            System.out.print("Level " + i + ": ");
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(19);
        skipList.insert(17);
        skipList.insert(26);
        skipList.insert(21);
        skipList.insert(25);

        System.out.println("Skip List after insertion:");
        skipList.printList();

        skipList.delete(3);
        skipList.delete(7);
        skipList.delete(9);

        System.out.println("Skip List after deletion:");
        skipList.printList();

        System.out.println("Search for 19: " + skipList.search(19));
        System.out.println("Search for 3: " + skipList.search(3));
    }
}

