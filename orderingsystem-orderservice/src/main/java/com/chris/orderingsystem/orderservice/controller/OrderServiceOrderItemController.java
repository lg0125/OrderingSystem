package com.chris.orderingsystem.orderservice.controller;

import java.util.Arrays;
import java.util.Map;


import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.orderservice.entity.OrderServiceOrderItemEntity;
import com.chris.orderingsystem.orderservice.service.OrderServiceOrderItemService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:31:17
 */
@RestController
@RequestMapping("orderservice/orderitem")
public class OrderServiceOrderItemController {
    @Autowired
    private OrderServiceOrderItemService orderServiceOrderItemService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderServiceOrderItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		OrderServiceOrderItemEntity orderServiceOrderItem = orderServiceOrderItemService.getById(id);

        return R.ok().put("orderServiceOrderItem", orderServiceOrderItem);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody OrderServiceOrderItemEntity orderServiceOrderItem){
		orderServiceOrderItemService.save(orderServiceOrderItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody OrderServiceOrderItemEntity orderServiceOrderItem){
		orderServiceOrderItemService.updateById(orderServiceOrderItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		orderServiceOrderItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
