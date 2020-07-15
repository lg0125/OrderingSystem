package com.chris.orderingsystem.webfront.feign;

import com.chris.orderingsystem.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;


@Component
@FeignClient("orderingsystem-productservice")
public interface ProductFeignService {

    @GetMapping("/productservice/feign/shops/{latitude}/{longitude}")
    R getShops(@PathVariable BigDecimal latitude, @PathVariable BigDecimal longitude);

    @GetMapping("/productservice/feign/shops/flavor")
    R getSearchShops(@RequestParam String flavor);

    @GetMapping("/productservice/feign/info/{shop_id}")
    R getShopInfo(@PathVariable Long shop_id);

    @GetMapping("/productservice/feign/goods/{shop_id}")
    R getShopGoods(@PathVariable Long shop_id);

}
