package com.ym.learn.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ym.learn.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();

    }

    @Test
    public void test() throws JsonProcessingException {
        User user = new User("杨明", 23);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user2",user);
        Object user1 = redisTemplate.opsForValue().get("user2");
        System.out.println(user1);

    }

    @Test
    public void testStringRedisTemplate(){
        User user = new User("杨明", 23);
        stringRedisTemplate.opsForValue().set("user3",user.toString());
    }

    @Test
    public void test2(){
        Short a = 127;
        Short b = 127;
        Short c = 32764;
        System.out.println("a==b:"+(a==b));
        System.out.println("b==c:"+(b==c));

    }

}
