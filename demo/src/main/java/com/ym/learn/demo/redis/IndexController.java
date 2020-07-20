package com.ym.learn.demo.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class IndexController {

    @Autowired
    private Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/deductStock")
    public String deductStock() throws InterruptedException {


        String clientId = UUID.randomUUID().toString().replace(".", "-");
        System.out.println(clientId);
        Boolean result = stringRedisTemplate.opsForValue().setIfAbsent("lock", clientId, 10, TimeUnit.SECONDS);

        if (!result) {
            return "error";
        }

        try {
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余库存：" + realStock);
            } else {
                System.out.println("扣减失败，库存不足");
            }
        } finally {
            //标识是否是自己的线程加的id
            if (clientId.equals(stringRedisTemplate.opsForValue().get("lock"))) {
                stringRedisTemplate.delete("lock");
            }
        }


        return "end";
    }

    @RequestMapping("/deductStock2")
    public String deductStock2() throws InterruptedException {
        RLock lock = redisson.getLock("lock");

        try {

            lock.lock();

            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余库存：" + realStock);
            } else {
                System.out.println("扣减失败，库存不足");
            }
        } finally {
            lock.unlock();
        }


        return "end";
    }
}
