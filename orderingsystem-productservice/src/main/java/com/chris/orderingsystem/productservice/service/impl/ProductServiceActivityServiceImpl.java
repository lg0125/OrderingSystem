package com.chris.orderingsystem.productservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.orderingsystem.productservice.dao.ProductServiceActivityDao;
import com.chris.orderingsystem.productservice.entity.ProductServiceActivityEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceActivityService;


@Service("productServiceActivityService")
public class ProductServiceActivityServiceImpl extends ServiceImpl<ProductServiceActivityDao, ProductServiceActivityEntity> implements ProductServiceActivityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductServiceActivityEntity> page = this.page(
                new Query<ProductServiceActivityEntity>().getPage(params),
                new QueryWrapper<ProductServiceActivityEntity>()
        );

        return new PageUtils(page);
    }

}