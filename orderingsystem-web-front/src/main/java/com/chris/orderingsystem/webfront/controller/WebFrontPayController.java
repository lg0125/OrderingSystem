package com.chris.orderingsystem.webfront.controller;

import com.chris.orderingsystem.common.utils.R;
import com.chris.orderingsystem.webfront.feign.PayFeignService;
import com.chris.orderingsystem.webfront.to.PayTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("front/pay")
public class WebFrontPayController {

    @Autowired
    PayFeignService payFeignService;

    @PostMapping("/pay")
    public R pay(@RequestBody PayTo payto){
        return payFeignService.pay(payto);
    }

}
