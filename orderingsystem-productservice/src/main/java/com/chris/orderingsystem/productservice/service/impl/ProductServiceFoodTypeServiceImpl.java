package com.chris.orderingsystem.productservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.orderingsystem.productservice.dao.ProductServiceFoodTypeDao;
import com.chris.orderingsystem.productservice.entity.ProductServiceFoodTypeEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceFoodTypeService;


@Service("productServiceFoodTypeService")
public class ProductServiceFoodTypeServiceImpl extends ServiceImpl<ProductServiceFoodTypeDao, ProductServiceFoodTypeEntity> implements ProductServiceFoodTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductServiceFoodTypeEntity> page = this.page(
                new Query<ProductServiceFoodTypeEntity>().getPage(params),
                new QueryWrapper<ProductServiceFoodTypeEntity>()
        );

        return new PageUtils(page);
    }

}