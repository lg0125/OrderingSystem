package com.chris.orderingsystem.productservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.orderingsystem.productservice.dao.ProductServiceProductOpLogDao;
import com.chris.orderingsystem.productservice.entity.ProductServiceProductOpLogEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceProductOpLogService;


@Service("productServiceProductOpLogService")
public class ProductServiceProductOpLogServiceImpl extends ServiceImpl<ProductServiceProductOpLogDao, ProductServiceProductOpLogEntity> implements ProductServiceProductOpLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductServiceProductOpLogEntity> page = this.page(
                new Query<ProductServiceProductOpLogEntity>().getPage(params),
                new QueryWrapper<ProductServiceProductOpLogEntity>()
        );

        return new PageUtils(page);
    }

}