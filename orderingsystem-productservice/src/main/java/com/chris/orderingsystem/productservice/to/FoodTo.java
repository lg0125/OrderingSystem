package com.chris.orderingsystem.productservice.to;

import com.chris.orderingsystem.productservice.entity.ProductServiceFoodTypeEntity;
import com.chris.orderingsystem.productservice.entity.ProductServiceShopFoodEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class FoodTo implements Serializable {
    private static final long serialVersionUID = 1L;

    private ProductServiceShopFoodEntity food;

    private ProductServiceFoodTypeEntity foodType;
}
