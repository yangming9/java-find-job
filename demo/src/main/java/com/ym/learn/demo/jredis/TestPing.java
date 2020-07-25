//package com.ym.learn.demo.jredis;
//
//import com.alibaba.fastjson.JSONObject;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.Transaction;
//
//public classadapter TestPing {
//    public static void main(String[] args) {
//        //1 new Jedis 对象即可
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.auth("123456");
//        jedis.select(2);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("hello","world");
//        jsonObject.put("name","yangming");
//        String string = jsonObject.toJSONString();
//        jedis.watch(string);
//        Transaction multi = jedis.multi();
//        try {
//            multi.set("user1",string);
//            multi.set("user2",string);
//            multi.exec();
//        }catch (Exception e){
//            multi.discard();
//            e.printStackTrace();
//        }finally {
//            System.out.println(jedis.get("user1"));
//            System.out.println(jedis.get("user2"));
//            jedis.flushDB();
//            jedis.unwatch();
//            jedis.close();
//        }
//
//    }
//}
