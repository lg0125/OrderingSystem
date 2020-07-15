package com.chris.orderingsystem.accountservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chris.orderingsystem.accountservice.entity.AccountServiceUserAddressEntity;
import com.chris.orderingsystem.accountservice.entity.AccountServiceUserEntity;
import com.chris.orderingsystem.accountservice.service.AccountServiceUserAddressService;
import com.chris.orderingsystem.accountservice.service.AccountServiceUserService;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("accountservice/feign")
public class AccountFeignController {

    @Autowired
    AccountServiceUserAddressService addressService;

    @Autowired
    AccountServiceUserService userService;

    @GetMapping("/address/{latitude}/{longitude}")
    public R  getAddress(@PathVariable BigDecimal latitude, @PathVariable BigDecimal longitude){
        Map<String,Object> map = new HashMap<>();
        map.put("latitude",latitude);
        map.put("longitude",longitude);
        QueryWrapper<AccountServiceUserAddressEntity> wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        AccountServiceUserAddressEntity address = addressService.getOne(wrapper);

        return R.ok().put("address",address);
    }

    @GetMapping("/user/info/{user_id}")
    public R getUserInfo(@PathVariable Long user_id){
        QueryWrapper<AccountServiceUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",user_id);
        AccountServiceUserEntity userInfo = userService.getOne(wrapper);

        return R.ok().put("userInfo",userInfo);
    }

    @GetMapping("/user/login/{user_id}/{user_password}")
    public R login(@PathVariable Long user_id, @PathVariable String user_password){
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("user_password",user_password);
        QueryWrapper<AccountServiceUserEntity> wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        AccountServiceUserEntity user = userService.getOne(wrapper);

        String result = "";
        result = (user == null) ? "error" : "success";

        return R.ok().put("result",result);
    }
}
