package com.aaa.swing.test;

import com.aaa.miaosha.redis.RedisService;
import com.aaa.miaosha.redis.UserKey;


import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest {
    @Autowired
    RedisService service;




    public static void main(String[] args) {
        RedisService service=new RedisService();
        boolean lo = service.set(UserKey.getById, "lo", "123");
        System.out.println(lo);
    }

}
