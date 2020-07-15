package com.chris.orderingsystem.productservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.orderingsystem.productservice.dao.ProductServiceShopFoodDao;
import com.chris.orderingsystem.productservice.entity.ProductServiceShopFoodEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceShopFoodService;


@Service("productServiceShopFoodService")
public class ProductServiceShopFoodServiceImpl extends ServiceImpl<ProductServiceShopFoodDao, ProductServiceShopFoodEntity> implements ProductServiceShopFoodService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductServiceShopFoodEntity> page = this.page(
                new Query<ProductServiceShopFoodEntity>().getPage(params),
                new QueryWrapper<ProductServiceShopFoodEntity>()
        );

        return new PageUtils(page);
    }

}