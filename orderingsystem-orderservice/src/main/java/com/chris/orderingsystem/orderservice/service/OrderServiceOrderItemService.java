package com.chris.orderingsystem.orderservice.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.orderservice.entity.OrderServiceOrderItemEntity;

import java.util.Map;

/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:31:17
 */
public interface OrderServiceOrderItemService extends IService<OrderServiceOrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

