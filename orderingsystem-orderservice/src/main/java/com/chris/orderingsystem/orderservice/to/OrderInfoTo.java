package com.chris.orderingsystem.orderservice.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInfoTo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer orderMoney;
    private Long orderId;
}
