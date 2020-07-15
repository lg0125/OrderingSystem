package com.chris.orderingsystem.productservice.controller;

import java.util.Arrays;
import java.util.Map;


import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.productservice.entity.ProductServiceShopInfoEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceShopInfoService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:53
 */
@RestController
@RequestMapping("productservice/shopinfo")
public class ProductServiceShopInfoController {
    @Autowired
    private ProductServiceShopInfoService productServiceShopInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productServiceShopInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ProductServiceShopInfoEntity productServiceShopInfo = productServiceShopInfoService.getById(id);

        return R.ok().put("productServiceShopInfo", productServiceShopInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProductServiceShopInfoEntity productServiceShopInfo){
		productServiceShopInfoService.save(productServiceShopInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProductServiceShopInfoEntity productServiceShopInfo){
		productServiceShopInfoService.updateById(productServiceShopInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		productServiceShopInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
