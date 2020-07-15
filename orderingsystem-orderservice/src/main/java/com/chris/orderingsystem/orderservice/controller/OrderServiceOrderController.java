package com.chris.orderingsystem.orderservice.controller;

import java.util.Arrays;
import java.util.Map;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.orderservice.entity.OrderServiceOrderEntity;
import com.chris.orderingsystem.orderservice.service.OrderServiceOrderService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:31:17
 */
@RestController
@RequestMapping("orderservice/order")
public class OrderServiceOrderController {
    @Autowired
    private OrderServiceOrderService orderServiceOrderService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderServiceOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{orderId}")
    public R info(@PathVariable("orderId") Long orderId){
		OrderServiceOrderEntity orderServiceOrder = orderServiceOrderService.getById(orderId);

        return R.ok().put("orderServiceOrder", orderServiceOrder);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody OrderServiceOrderEntity orderServiceOrder){
		orderServiceOrderService.save(orderServiceOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody OrderServiceOrderEntity orderServiceOrder){
		orderServiceOrderService.updateById(orderServiceOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] orderIds){
		orderServiceOrderService.removeByIds(Arrays.asList(orderIds));

        return R.ok();
    }

}
