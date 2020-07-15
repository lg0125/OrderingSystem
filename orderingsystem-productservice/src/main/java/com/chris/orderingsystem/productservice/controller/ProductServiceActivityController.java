package com.chris.orderingsystem.productservice.controller;

import java.util.Arrays;
import java.util.Map;


import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.productservice.entity.ProductServiceActivityEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceActivityService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:53
 */
@RestController
@RequestMapping("productservice/activity")
public class ProductServiceActivityController {
    @Autowired
    private ProductServiceActivityService productServiceActivityService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productServiceActivityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ProductServiceActivityEntity productServiceActivity = productServiceActivityService.getById(id);

        return R.ok().put("productServiceActivity", productServiceActivity);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProductServiceActivityEntity productServiceActivity){
		productServiceActivityService.save(productServiceActivity);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProductServiceActivityEntity productServiceActivity){
		productServiceActivityService.updateById(productServiceActivity);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		productServiceActivityService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
