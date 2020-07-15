package com.chris.orderingsystem.productservice.controller;

import java.util.Arrays;
import java.util.Map;


import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.productservice.entity.ProductServiceShopAddressEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceShopAddressService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:53
 */
@RestController
@RequestMapping("productservice/shopaddress")
public class ProductServiceShopAddressController {
    @Autowired
    private ProductServiceShopAddressService productServiceShopAddressService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productServiceShopAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ProductServiceShopAddressEntity productServiceShopAddress = productServiceShopAddressService.getById(id);

        return R.ok().put("productServiceShopAddress", productServiceShopAddress);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProductServiceShopAddressEntity productServiceShopAddress){
		productServiceShopAddressService.save(productServiceShopAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProductServiceShopAddressEntity productServiceShopAddress){
		productServiceShopAddressService.updateById(productServiceShopAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		productServiceShopAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
