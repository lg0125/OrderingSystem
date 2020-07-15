package com.chris.orderingsystem.productservice.controller;

import java.util.Arrays;
import java.util.Map;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.productservice.entity.ProductServiceSupportEntity;
import com.chris.orderingsystem.productservice.service.ProductServiceSupportService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:53
 */
@RestController
@RequestMapping("productservice/support")
public class ProductServiceSupportController {
    @Autowired
    private ProductServiceSupportService productServiceSupportService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productServiceSupportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ProductServiceSupportEntity productServiceSupport = productServiceSupportService.getById(id);

        return R.ok().put("productServiceSupport", productServiceSupport);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProductServiceSupportEntity productServiceSupport){
		productServiceSupportService.save(productServiceSupport);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProductServiceSupportEntity productServiceSupport){
		productServiceSupportService.updateById(productServiceSupport);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		productServiceSupportService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
