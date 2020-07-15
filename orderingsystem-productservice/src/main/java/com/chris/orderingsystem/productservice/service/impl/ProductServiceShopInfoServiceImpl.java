package com.chris.orderingsystem.productservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.orderingsystem.productservice.dao.ProductServiceShopInfoDao;
import com.chris.orderingsystem.productservice.entity.ProductServiceShopInfoEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceShopInfoService;


@Service("productServiceShopInfoService")
public class ProductServiceShopInfoServiceImpl extends ServiceImpl<ProductServiceShopInfoDao, ProductServiceShopInfoEntity> implements ProductServiceShopInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductServiceShopInfoEntity> page = this.page(
                new Query<ProductServiceShopInfoEntity>().getPage(params),
                new QueryWrapper<ProductServiceShopInfoEntity>()
        );

        return new PageUtils(page);
    }

}