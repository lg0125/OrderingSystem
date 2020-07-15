package com.chris.orderingsystem.productservice.to;

import com.chris.orderingsystem.productservice.entity.ProductServiceActivityEntity;
import com.chris.orderingsystem.productservice.entity.ProductServiceShopAddressEntity;
import com.chris.orderingsystem.productservice.entity.ProductServiceShopInfoEntity;
import com.chris.orderingsystem.productservice.entity.ProductServiceSupportEntity;
import lombok.Data;

import java.io.Serializable;


@Data
public class ShopTo implements Serializable {
    private static final long serialVersionUID = 1L;

    private ProductServiceShopInfoEntity info;
    private ProductServiceShopAddressEntity address;
    private ProductServiceSupportEntity support;
    private ProductServiceActivityEntity activity;
}
