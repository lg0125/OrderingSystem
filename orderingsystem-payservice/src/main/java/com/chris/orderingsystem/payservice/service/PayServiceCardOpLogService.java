package com.chris.orderingsystem.payservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.payservice.entity.PayServiceCardOpLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:33:22
 */
public interface PayServiceCardOpLogService extends IService<PayServiceCardOpLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

