package com.chris.orderingsystem.webfront.feign;

import com.chris.orderingsystem.common.utils.R;
import com.chris.orderingsystem.webfront.to.OrderItemTo;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient("orderingsystem-orderservice")
public interface OrderFeignService {

    @PostMapping("/orderservice/feign/save/{user_id}/{shop_id}")
    R save(@RequestBody List<OrderItemTo> items, @PathVariable Long user_id, @PathVariable Long shop_id);

}
