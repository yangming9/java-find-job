package com.ym.learn.demo.wangning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputStr {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 初始化list并存储用户输入（需要改成用户输入）
        List list = new ArrayList();

        if (input.hasNext()){
            String str = input.next();
            list.add(str);
        }

        System.out.println("请输入字符：");
        // 接受输入
        String wenzi = input.next();
        // 设定符合词组条数
        int num = 1;
        // 声明map数组，存取结果
        Map map = new HashMap();
        // 遍历数组，查找相应词组
        for (int i = 0; i < list.size(); i++) {
        // 取得对应下标的词组
            String one = (String) list.get(i);
        // 比较用户输入字符和取出的词组的第一个字符
            if (one.equals(wenzi)) {
                map.put(num, one); //把结果存到map中
                num++;
            }
        // 如果无对应词组提示
            if (i == list.size() - 1 && num == 1) {
                System.out.println("无相应词组！" + wenzi);
                return;
            }
        }
        // 接受用户选择
        int result;
        while (1 == 1) {
            System.out.println("\n请输入您要选择的字符：");
            String re = input.next();
            try {
                result = Integer.parseInt(re);
                break;
            } catch (Exception ex) {
                System.out.println("输入错误，请重新输入！");
                continue;
            }
        }
        if (result < num) {
            System.out.println(((String) map.get(result)).substring(1));
        } else {
            System.out.println("就这么多了！");
        }
    }
}
