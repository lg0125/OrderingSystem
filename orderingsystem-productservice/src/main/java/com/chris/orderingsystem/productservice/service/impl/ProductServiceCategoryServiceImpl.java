package com.chris.orderingsystem.productservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.chris.orderingsystem.productservice.dao.ProductServiceCategoryDao;
import com.chris.orderingsystem.productservice.entity.ProductServiceCategoryEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceCategoryService;


@Service("productServiceCategoryService")
public class ProductServiceCategoryServiceImpl extends ServiceImpl<ProductServiceCategoryDao, ProductServiceCategoryEntity> implements ProductServiceCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductServiceCategoryEntity> page = this.page(
                new Query<ProductServiceCategoryEntity>().getPage(params),
                new QueryWrapper<ProductServiceCategoryEntity>()
        );

        return new PageUtils(page);
    }

}