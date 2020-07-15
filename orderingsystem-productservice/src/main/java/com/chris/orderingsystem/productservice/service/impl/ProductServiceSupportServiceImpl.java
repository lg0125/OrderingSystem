package com.chris.orderingsystem.productservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.orderingsystem.productservice.dao.ProductServiceSupportDao;
import com.chris.orderingsystem.productservice.entity.ProductServiceSupportEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceSupportService;


@Service("productServiceSupportService")
public class ProductServiceSupportServiceImpl extends ServiceImpl<ProductServiceSupportDao, ProductServiceSupportEntity> implements ProductServiceSupportService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductServiceSupportEntity> page = this.page(
                new Query<ProductServiceSupportEntity>().getPage(params),
                new QueryWrapper<ProductServiceSupportEntity>()
        );

        return new PageUtils(page);
    }

}