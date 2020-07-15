package com.chris.orderingsystem.orderservice.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.orderservice.entity.OrderServiceOrderEntity;

import java.util.Map;

/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:31:17
 */
public interface OrderServiceOrderService extends IService<OrderServiceOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

