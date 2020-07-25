package com.ym.learn.demo.designpatterns.kuangshen.prototype.demo1;

import java.util.Date;

public class Video implements Cloneable{
    private String name;
    private Date createTime;

    public Video() {
    }

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        return super.clone();
//    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Object obj = super.clone();

        Video v = (Video)obj;
        v.createTime = (Date)this.createTime.clone();//将这个对象的属性也进行克隆
        v.name = this.name;
        return obj;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
