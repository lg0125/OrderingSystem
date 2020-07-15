package com.chris.orderingsystem.accountservice.controller;

import java.util.Arrays;
import java.util.Map;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.accountservice.entity.AccountServiceAdminEntity;
import com.chris.orderingsystem.accountservice.service.AccountServiceAdminService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:34:28
 */
@RestController
@RequestMapping("accountservice/admin")
public class AccountServiceAdminController {
    @Autowired
    private AccountServiceAdminService accountServiceAdminService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountServiceAdminService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		AccountServiceAdminEntity accountServiceAdmin = accountServiceAdminService.getById(id);

        return R.ok().put("accountServiceAdmin", accountServiceAdmin);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody AccountServiceAdminEntity accountServiceAdmin){
		accountServiceAdminService.save(accountServiceAdmin);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody AccountServiceAdminEntity accountServiceAdmin){
		accountServiceAdminService.updateById(accountServiceAdmin);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		accountServiceAdminService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
