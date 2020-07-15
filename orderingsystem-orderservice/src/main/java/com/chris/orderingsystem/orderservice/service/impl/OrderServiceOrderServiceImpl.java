package com.chris.orderingsystem.orderservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.chris.orderingsystem.orderservice.dao.OrderServiceOrderDao;
import com.chris.orderingsystem.orderservice.entity.OrderServiceOrderEntity;
import com.chris.orderingsystem.orderservice.service.OrderServiceOrderService;


@Service("orderServiceOrderService")
public class OrderServiceOrderServiceImpl extends ServiceImpl<OrderServiceOrderDao, OrderServiceOrderEntity> implements OrderServiceOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderServiceOrderEntity> page = this.page(
                new Query<OrderServiceOrderEntity>().getPage(params),
                new QueryWrapper<OrderServiceOrderEntity>()
        );

        return new PageUtils(page);
    }

}