package com.chris.orderingsystem.webfront.feign;

import com.chris.orderingsystem.common.utils.R;
import com.chris.orderingsystem.webfront.to.PayTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Component
@FeignClient("orderingsystem-payservice")
public interface PayFeignService {

    @PostMapping("/payservice/feign/pay")
    R pay(@RequestBody PayTo payto);

}
