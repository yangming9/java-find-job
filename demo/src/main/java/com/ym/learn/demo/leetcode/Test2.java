package com.ym.learn.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        getRow(2);
    }
    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            if (i == 0) {
                list.add(1);
            } else {
                long num = (long)list.get(i - 1) * (long)(rowIndex - i) / i;
                list.add((int)num);
            }
        }
        return list;
    }
}
