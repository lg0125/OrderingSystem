package com.chris.orderingsystem.webfront.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class PayTo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cardId;

    private String cardPassword;

    private Integer payMoney;

    private Long orderId;

    private Integer orderMoney;
}
