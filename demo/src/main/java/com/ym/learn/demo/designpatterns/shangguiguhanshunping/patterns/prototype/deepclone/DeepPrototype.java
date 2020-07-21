package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.prototype.deepclone;

import java.io.*;

public class DeepPrototype implements Serializable, Cloneable {
    public String name;//String类型
    public DeepCloneableTarget deepCloneableTarget;//引用类型的属性

    public DeepPrototype() {
        super();
    }

    //深拷贝实现方式一：重写clone方法实现
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //1.这里完成对基本数据类型属性的clone
        deep = super.clone();
        //2.对引用类型的属性进行单独的处理
        DeepPrototype deepPrototype = (DeepPrototype) deep;
        deepPrototype.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

        return deepPrototype;
    }

    //深拷贝实现方式二：通过对象的序列化实现（推荐使用）
    public Object deepClone() {
        //1.创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//当前这个对象以对象流的方式输出

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            DeepPrototype copyObj = (DeepPrototype) ois.readObject();
            return copyObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
