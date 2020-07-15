package com.chris.orderingsystem.accountservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.chris.orderingsystem.accountservice.dao")
@SpringBootApplication
public class OrderingsystemAccountserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingsystemAccountserviceApplication.class, args);
    }

}
