package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.enjoyyuan;

import java.util.HashMap;

//网站工厂类，根据需求返回一个网站
public class WebsiteFactory {
    //集合  充当池的作用
    private HashMap<String,ConcreteWebsite> pool = new HashMap<>();

    //根据网站的类型  返回一个网站  如果没有 就创建一个网站 放入pool中
    public Website getWebsiteCategory(String type){
        if (!pool.containsKey(type)){
            pool.put(type,new ConcreteWebsite(type));
        }

        return (Website) pool.get(type);
    }

    //获取网站分类的总数（pool中有多少实际的网站）
    public int getWebsiteCount(){
        return pool.size();
    }
}
