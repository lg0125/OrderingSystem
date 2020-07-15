package com.chris.orderingsystem.webfront.controller;

import com.chris.orderingsystem.common.utils.R;
import com.chris.orderingsystem.webfront.feign.OrderFeignService;
import com.chris.orderingsystem.webfront.to.OrderItemTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("front/order")
public class WebFrontOrderController {

    @Autowired
    OrderFeignService orderFeignService;

    @PostMapping("/save/{user_id}/{shop_id}")
    public R save(@RequestBody List<OrderItemTo> items, @PathVariable Long user_id, @PathVariable Long shop_id){
        return orderFeignService.save(items,user_id,shop_id);
    }

}

