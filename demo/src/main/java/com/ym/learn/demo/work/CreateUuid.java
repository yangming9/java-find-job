package com.ym.learn.demo.work;

import java.util.UUID;

public class CreateUuid {
    public static String getUserToken(){
        UUID uuid = UUID.randomUUID();
        String tokenString = uuid.toString().replace("-", "");
        return tokenString;
    }

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", "");
        System.out.println(uuidString);
    }
}
