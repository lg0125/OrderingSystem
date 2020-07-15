package com.chris.orderingsystem.webfront.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderItemTo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long foodId;
    private Integer foodAccount;
    private Integer foodNum;
}
