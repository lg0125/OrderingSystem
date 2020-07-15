package com.chris.orderingsystem.orderservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.chris.orderingsystem.orderservice.dao")
@SpringBootApplication
public class OrderingsystemOrderserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingsystemOrderserviceApplication.class, args);
    }

}
