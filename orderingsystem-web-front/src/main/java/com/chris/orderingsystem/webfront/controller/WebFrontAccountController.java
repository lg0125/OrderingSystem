package com.chris.orderingsystem.webfront.controller;


import com.chris.orderingsystem.common.utils.R;
import com.chris.orderingsystem.webfront.feign.AccountFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping("front/account")
public class WebFrontAccountController {

    @Autowired
    AccountFeignService accountFeignService;

    @GetMapping("/address/{latitude}/{longitude}")
    public R getAddress(@PathVariable BigDecimal latitude, @PathVariable BigDecimal longitude){
        return accountFeignService.getAddress(latitude,longitude);
    }

    @GetMapping("/user/info/{user_id}")
    public R getUserInfo(@PathVariable Long user_id){
        return accountFeignService.getUserInfo(user_id);
    }

    @GetMapping("/user/login/{user_id}/{user_password}")
    public R login(@PathVariable Long user_id, @PathVariable String user_password){
        return accountFeignService.login(user_id,user_password);
    }
}
