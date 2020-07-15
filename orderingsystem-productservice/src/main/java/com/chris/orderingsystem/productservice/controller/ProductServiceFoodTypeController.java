package com.chris.orderingsystem.productservice.controller;

import java.util.Arrays;
import java.util.Map;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.productservice.entity.ProductServiceFoodTypeEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceFoodTypeService;



/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:53
 */
@RestController
@RequestMapping("productservice/foodtype")
public class ProductServiceFoodTypeController {
    @Autowired
    private ProductServiceFoodTypeService productServiceFoodTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productServiceFoodTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ProductServiceFoodTypeEntity productServiceFoodType = productServiceFoodTypeService.getById(id);

        return R.ok().put("productServiceFoodType", productServiceFoodType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProductServiceFoodTypeEntity productServiceFoodType){
		productServiceFoodTypeService.save(productServiceFoodType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProductServiceFoodTypeEntity productServiceFoodType){
		productServiceFoodTypeService.updateById(productServiceFoodType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		productServiceFoodTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
