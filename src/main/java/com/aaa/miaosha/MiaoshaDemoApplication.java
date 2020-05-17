package com.aaa.miaosha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.aaa.miaosha.dao")
@SpringBootApplication
public class MiaoshaDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MiaoshaDemoApplication.class, args);
    }

}
