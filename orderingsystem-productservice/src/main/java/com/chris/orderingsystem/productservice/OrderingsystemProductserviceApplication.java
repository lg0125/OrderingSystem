package com.chris.orderingsystem.productservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.chris.orderingsystem.productservice.dao")
@SpringBootApplication
public class OrderingsystemProductserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingsystemProductserviceApplication.class, args);
    }

}
