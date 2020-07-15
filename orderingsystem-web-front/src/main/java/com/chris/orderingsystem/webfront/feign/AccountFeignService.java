package com.chris.orderingsystem.webfront.feign;

import com.chris.orderingsystem.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@Component
@FeignClient("orderingsystem-accountservice")
public interface AccountFeignService {

    @GetMapping("/accountservice/feign/address/{latitude}/{longitude}")
    R getAddress(@PathVariable BigDecimal latitude, @PathVariable BigDecimal longitude);

    @GetMapping("/accountservice/feign/user/info/{user_id}")
    R getUserInfo(@PathVariable Long user_id);

    @GetMapping("/accountservice/feign/user/login/{user_id}/{user_password}")
    R login(@PathVariable Long user_id, @PathVariable String user_password);

}
