package com.ym.learn.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角的动态规划方法
 */
public class Test1 {
    public static void main(String[] args) {
        generate(2);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) {
            return list;
        }

        List<Integer> row = new ArrayList<>();
        row.add(1);
        list.add(row);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> rowI = new ArrayList<>();
            List<Integer> preRow = list.get(i - 2);
            rowI.add(1);
            for (int j = 1; j < i - 1; j++) {
                rowI.add(preRow.get(j) + preRow.get(j - 1));
            }
            rowI.add(1);
            list.add(rowI);
        }
        return list;
    }
}
