package com.chris.orderingsystem.productservice.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.productservice.entity.ProductServiceShopAddressEntity;

import java.util.Map;

/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:53
 */
public interface ProductServiceShopAddressService extends IService<ProductServiceShopAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

