package com.chris.orderingsystem.productservice.controller;

import java.util.Arrays;
import java.util.Map;


import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.productservice.entity.ProductServiceShopFoodEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceShopFoodService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:53
 */
@RestController
@RequestMapping("productservice/shopfood")
public class ProductServiceShopFoodController {
    @Autowired
    private ProductServiceShopFoodService productServiceShopFoodService;

    /**
     * 列表
     */
    @GetMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productServiceShopFoodService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ProductServiceShopFoodEntity productServiceShopFood = productServiceShopFoodService.getById(id);

        return R.ok().put("productServiceShopFood", productServiceShopFood);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProductServiceShopFoodEntity productServiceShopFood){
		productServiceShopFoodService.save(productServiceShopFood);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProductServiceShopFoodEntity productServiceShopFood){
		productServiceShopFoodService.updateById(productServiceShopFood);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		productServiceShopFoodService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
