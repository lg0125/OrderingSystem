package com.chris.orderingsystem.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderingsystemGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderingsystemGatewayApplication.class);
    }
}
