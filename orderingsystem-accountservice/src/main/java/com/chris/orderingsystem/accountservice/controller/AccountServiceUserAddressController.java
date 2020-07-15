package com.chris.orderingsystem.accountservice.controller;

import java.util.Arrays;
import java.util.Map;


import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.accountservice.entity.AccountServiceUserAddressEntity;
import com.chris.orderingsystem.accountservice.service.AccountServiceUserAddressService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:34:28
 */
@RestController
@RequestMapping("accountservice/address")
public class AccountServiceUserAddressController {
    @Autowired
    private AccountServiceUserAddressService accountServiceUserAddressService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountServiceUserAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		AccountServiceUserAddressEntity accountServiceUserAddress = accountServiceUserAddressService.getById(id);

        return R.ok().put("accountServiceUserAddress", accountServiceUserAddress);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody AccountServiceUserAddressEntity accountServiceUserAddress){
		accountServiceUserAddressService.save(accountServiceUserAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody AccountServiceUserAddressEntity accountServiceUserAddress){
		accountServiceUserAddressService.updateById(accountServiceUserAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		accountServiceUserAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
