package com.chris.orderingsystem.productservice.controller;

import java.util.Arrays;
import java.util.Map;


import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.productservice.entity.ProductServiceCategoryEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceCategoryService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:52
 */
@RestController
@RequestMapping("productservice/category")
public class ProductServiceCategoryController {
    @Autowired
    private ProductServiceCategoryService productServiceCategoryService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productServiceCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ProductServiceCategoryEntity productServiceCategory = productServiceCategoryService.getById(id);

        return R.ok().put("productServiceCategory", productServiceCategory);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProductServiceCategoryEntity productServiceCategory){
		productServiceCategoryService.save(productServiceCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProductServiceCategoryEntity productServiceCategory){
		productServiceCategoryService.updateById(productServiceCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		productServiceCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
