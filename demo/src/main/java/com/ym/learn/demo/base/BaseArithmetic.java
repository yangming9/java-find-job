package com.ym.learn.demo.base;

import com.ym.learn.demo.cas.CASDemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基础算数运算
 */
public class BaseArithmetic {

    private static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk+1 < n && !occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }

            ans = Math.max(ans,rk+1-i);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) throws InterruptedException {
//        String str = "abbcabdreda";
//        System.out.println(str.indexOf("e",7));
////        System.out.println(lengthOfLongestSubstring2(str));
//        String str2 = str+"asfas";
//        System.out.println(str2);
        String a = "bb";
        String bb = new String("bb");
        String b = bb;
        System.out.println("a hashcode=" + a.hashCode());
        System.out.println("a addr = " + System.identityHashCode(a));
        System.out.println("bb hashcode=" + bb.hashCode());
        System.out.println("bb addr = " + System.identityHashCode(bb));
        System.out.println("b hashcode=" + b.hashCode());
        System.out.println("b addr = " + System.identityHashCode(b));
        System.out.println("a==b: " + (a == b));
        Map<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(1, "56");
        objectObjectHashMap.put(4, "45");
        objectObjectHashMap.put(17, "45");
        objectObjectHashMap.put(2, "123");
        System.out.println(objectObjectHashMap.toString());
        Map<Object, Object> sortMap = new TreeMap<>(objectObjectHashMap);
        System.out.println(sortMap.toString());
        ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<String, AtomicInteger>();
        AtomicInteger integer = new AtomicInteger(1);
        map.put("key", integer);
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
//                map.get("key").incrementAndGet();
                System.out.println(Thread.currentThread().getName()+"------" + CASDemo.ON_LINE_SERVICE.incrementAndGet() + "------");
            },(i+1)+"").start();
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    map.get("key").incrementAndGet();
//                }
//            });
//        }
            Thread.sleep(300); //模拟等待执行结束
//        executorService.shutdown();
        }

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
            }
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }

        }, "线程 1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
            }
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }

        }, "线程 2").start();
    }
}
