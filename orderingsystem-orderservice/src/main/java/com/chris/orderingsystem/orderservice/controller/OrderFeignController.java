package com.chris.orderingsystem.orderservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chris.orderingsystem.common.utils.R;
import com.chris.orderingsystem.orderservice.entity.OrderServiceOrderEntity;
import com.chris.orderingsystem.orderservice.entity.OrderServiceOrderItemEntity;
import com.chris.orderingsystem.orderservice.service.OrderServiceOrderItemService;
import com.chris.orderingsystem.orderservice.service.OrderServiceOrderService;
import com.chris.orderingsystem.orderservice.to.OrderInfoTo;
import com.chris.orderingsystem.orderservice.to.OrderItemTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("orderservice/feign")
public class OrderFeignController {

    @Autowired
    OrderServiceOrderItemService itemService;

    @Autowired
    OrderServiceOrderService orderService;

    @PostMapping("/save/{user_id}/{shop_id}")
    public R save(@RequestBody List<OrderItemTo> items, @PathVariable Long user_id, @PathVariable Long shop_id){
        OrderServiceOrderEntity order = new OrderServiceOrderEntity();
        Long order_index = random(user_id,shop_id);
        order.setUserId(user_id);
        order.setShopId(shop_id);
        order.setOrderIndex(order_index);
        orderService.save(order);

        Map<String,Object> map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("shop_id",shop_id);
        map.put("order_index",order_index);
        QueryWrapper<OrderServiceOrderEntity> wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        OrderServiceOrderEntity newOrder = orderService.getOne(wrapper);

        Long orderId = newOrder.getOrderId();
        Integer orderAccount = 0;
        for(OrderItemTo item:items) {
            OrderServiceOrderItemEntity itemEntity = new OrderServiceOrderItemEntity();
            itemEntity.setFoodId(item.getFoodId());
            itemEntity.setFoodAccount(item.getFoodAccount());
            itemEntity.setFoodNum(item.getFoodNum());
            itemEntity.setOrderId(orderId);
            itemEntity.setShopId(shop_id);
            itemService.save(itemEntity);
            orderAccount += item.getFoodAccount() * item.getFoodNum();
        }

        newOrder.setOrderAccount(orderAccount);
        orderService.update(newOrder,wrapper);

        OrderInfoTo orderInfo = new OrderInfoTo();
        orderInfo.setOrderId(orderId);
        orderInfo.setOrderMoney(orderAccount);
        return R.ok().put("orderInfo",orderInfo);
    }

    private Long random(Long user_id,Long shop_id){
        int max = 10000,min = 1000;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        Long temp = Long.parseLong(Integer.toString(s));
        return temp + user_id + shop_id;
    }

}
