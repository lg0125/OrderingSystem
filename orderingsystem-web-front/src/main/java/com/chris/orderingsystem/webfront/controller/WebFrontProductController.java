package com.chris.orderingsystem.webfront.controller;

import com.chris.orderingsystem.common.utils.R;
import com.chris.orderingsystem.webfront.feign.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping("front/product")
public class WebFrontProductController {

    @Autowired
    ProductFeignService productFeignService;

    @GetMapping("/shops/{latitude}/{longitude}")
    public R getShops(@PathVariable BigDecimal latitude, @PathVariable BigDecimal longitude){
        return productFeignService.getShops(latitude,longitude);
    }

    @GetMapping("/shops/flavor")
    public R getSearchShops(@RequestParam String flavor){
        return productFeignService.getSearchShops(flavor);
    }

    @GetMapping("/info/{shop_id}")
    public R getShopInfo(@PathVariable Long shop_id){
        return productFeignService.getShopInfo(shop_id);
    }

    @GetMapping("/goods/{shop_id}")
    public R getShopGoods(@PathVariable Long shop_id){
        return productFeignService.getShopGoods(shop_id);
    }

}
