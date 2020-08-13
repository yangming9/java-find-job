package com.ym.learn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean(destroyMethod = "shutdown")
//    public Redisson redisson() throws IOException {
////        目前使用是单机模式
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(2).setPassword("123456");
//        /*
//         如果是集群模式
//         config.useClusterServers().addNodeAddress("redis://IP+Port")
//                .addNodeAddress("redis://IP+Port")
//                .addNodeAddress("redis://IP+Port")
//                .addNodeAddress("redis://IP+Port")
//                .addNodeAddress("redis://IP+Port")
//                .addNodeAddress("redis://IP+Port");
//         */
//
//        return (Redisson) Redisson.create(config);
//    }

}
