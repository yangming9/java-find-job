package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.enjoyyuan;

public class Client {
    public static void main(String[] args) {
        //创建一个工厂类
        WebsiteFactory websiteFactory = new WebsiteFactory();
        //客户要一个以新闻形式发布的网站
        Website website = websiteFactory.getWebsiteCategory("新闻");

        website.use(new User("tom"));

        //客户要以博客形式发布网站

        Website website1 = websiteFactory.getWebsiteCategory("博客");

        website1.use(new User("jack"));
        Website website2 = websiteFactory.getWebsiteCategory("博客");
        website2.use(new User("wiki"));
        System.out.println(websiteFactory.getWebsiteCount());
    }
}
