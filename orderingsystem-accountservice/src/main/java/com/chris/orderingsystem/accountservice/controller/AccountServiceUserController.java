package com.chris.orderingsystem.accountservice.controller;

import java.util.Arrays;
import java.util.Map;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.accountservice.entity.AccountServiceUserEntity;
import com.chris.orderingsystem.accountservice.service.AccountServiceUserService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:34:28
 */
@RestController
@RequestMapping("accountservice/user")
public class AccountServiceUserController {
    @Autowired
    private AccountServiceUserService accountServiceUserService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountServiceUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		AccountServiceUserEntity accountServiceUser = accountServiceUserService.getById(id);

        return R.ok().put("accountServiceUser", accountServiceUser);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody AccountServiceUserEntity accountServiceUser){
		accountServiceUserService.save(accountServiceUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody AccountServiceUserEntity accountServiceUser){
		accountServiceUserService.updateById(accountServiceUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		accountServiceUserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
