package com.ym.learn.demo.designpatterns.kuangshen.single2;

/**
 * 枚举实现单例模式   解决了线程同步，还可以防止反序列化（枚举类没有构造方法，因此拿不到class，不能被反序列化）
 */
public enum SingleClass {

    INSTANCE;

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0;i<100;i++){
          new Thread(() -> {
              System.out.println(SingleClass.INSTANCE.hashCode());
          }).start();
        }
    }
}
