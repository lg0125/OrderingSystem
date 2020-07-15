package com.chris.orderingsystem.orderservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.chris.orderingsystem.orderservice.dao.OrderServiceOrderItemDao;
import com.chris.orderingsystem.orderservice.entity.OrderServiceOrderItemEntity;
import com.chris.orderingsystem.orderservice.service.OrderServiceOrderItemService;


@Service("orderServiceOrderItemService")
public class OrderServiceOrderItemServiceImpl extends ServiceImpl<OrderServiceOrderItemDao, OrderServiceOrderItemEntity> implements OrderServiceOrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderServiceOrderItemEntity> page = this.page(
                new Query<OrderServiceOrderItemEntity>().getPage(params),
                new QueryWrapper<OrderServiceOrderItemEntity>()
        );

        return new PageUtils(page);
    }

}