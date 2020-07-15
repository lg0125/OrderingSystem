package com.chris.orderingsystem.payservice.controller;

import java.util.Arrays;
import java.util.Map;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.payservice.entity.PayServiceCardEntity;
import com.chris.orderingsystem.payservice.service.PayServiceCardService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:33:22
 */
@RestController
@RequestMapping("payservice/card")
public class PayServiceCardController {
    @Autowired
    private PayServiceCardService payServiceCardService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = payServiceCardService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PayServiceCardEntity payServiceCard = payServiceCardService.getById(id);

        return R.ok().put("payServiceCard", payServiceCard);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody PayServiceCardEntity payServiceCard){
		payServiceCardService.save(payServiceCard);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody PayServiceCardEntity payServiceCard){
		payServiceCardService.updateById(payServiceCard);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		payServiceCardService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
