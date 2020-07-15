package com.chris.orderingsystem.payservice.controller;

import java.util.Arrays;
import java.util.Map;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.orderingsystem.payservice.entity.PayServiceCardOpLogEntity;
import com.chris.orderingsystem.payservice.service.PayServiceCardOpLogService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:33:22
 */
@RestController
@RequestMapping("payservice/cardoplog")
public class PayServiceCardOpLogController {
    @Autowired
    private PayServiceCardOpLogService payServiceCardOpLogService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = payServiceCardOpLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PayServiceCardOpLogEntity payServiceCardOpLog = payServiceCardOpLogService.getById(id);

        return R.ok().put("payServiceCardOpLog", payServiceCardOpLog);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody PayServiceCardOpLogEntity payServiceCardOpLog){
		payServiceCardOpLogService.save(payServiceCardOpLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody PayServiceCardOpLogEntity payServiceCardOpLog){
		payServiceCardOpLogService.updateById(payServiceCardOpLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		payServiceCardOpLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
