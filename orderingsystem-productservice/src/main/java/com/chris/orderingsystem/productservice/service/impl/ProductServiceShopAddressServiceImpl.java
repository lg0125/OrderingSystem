package com.chris.orderingsystem.productservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.orderingsystem.productservice.dao.ProductServiceShopAddressDao;
import com.chris.orderingsystem.productservice.entity.ProductServiceShopAddressEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceShopAddressService;


@Service("productServiceShopAddressService")
public class ProductServiceShopAddressServiceImpl extends ServiceImpl<ProductServiceShopAddressDao, ProductServiceShopAddressEntity> implements ProductServiceShopAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductServiceShopAddressEntity> page = this.page(
                new Query<ProductServiceShopAddressEntity>().getPage(params),
                new QueryWrapper<ProductServiceShopAddressEntity>()
        );

        return new PageUtils(page);
    }

}