package com.ym.learn.demo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 */
public class TanXin {
    public static void main(String[] args) {
        //创建广播电台到map中
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放到broadcasts
        HashSet<String> set = new HashSet<>();
        set.add("北京");
        set.add("上海");
        set.add("天津");

        HashSet<String> set1 = new HashSet<>();
        set1.add("广州");
        set1.add("北京");
        set1.add("深圳");

        HashSet<String> set2 = new HashSet<>();
        set2.add("成都");
        set2.add("上海");
        set2.add("杭州");

        HashSet<String> set3 = new HashSet<>();
        set3.add("上海");
        set3.add("天津");

        HashSet<String> set4 = new HashSet<>();
        set4.add("杭州");
        set4.add("大连");

        broadcasts.put("K1",set);
        broadcasts.put("K2",set1);
        broadcasts.put("K3",set2);
        broadcasts.put("K4",set3);
        broadcasts.put("K5",set4);

        //存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("深圳");

        //上述都是算法的准备工作

        /**
         * 下面正式开始算法
         */
        //创建ArrayList，存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义一个maxKey 保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应电台的key
        //如果maxKey不为null 则会加入到selects
        String maxKey = null;

        while (allAreas.size() != 0){//说明还没覆盖到所有的地区
            maxKey = null;
            //遍历电台集合 取出电台对应的key
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                //当前key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas 的交集，交集会赋给tempSet
                tempSet.retainAll(allAreas);
                //tempSet.size() > broadcasts.get(maxKey).size() 体现出贪心算法 每次都是选择最好的结果
                if (tempSet.size()>0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                        maxKey = key;
                }
            }
            //如果maxKey != null 就应该将maxKey加入到selects
            if (maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("selects: "+selects);
    }
}
