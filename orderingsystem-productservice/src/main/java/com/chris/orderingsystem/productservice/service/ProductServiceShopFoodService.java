package com.chris.orderingsystem.productservice.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.productservice.entity.ProductServiceShopFoodEntity;

import java.util.Map;

/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:53
 */
public interface ProductServiceShopFoodService extends IService<ProductServiceShopFoodEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

