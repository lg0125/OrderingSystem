package com.chris.orderingsystem.webback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderingsystemWebBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingsystemWebBackApplication.class, args);
    }

}
