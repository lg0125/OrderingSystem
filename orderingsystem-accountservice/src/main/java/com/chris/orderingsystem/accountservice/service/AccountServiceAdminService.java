package com.chris.orderingsystem.accountservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.orderingsystem.accountservice.entity.AccountServiceAdminEntity;
import com.chris.orderingsystem.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:34:28
 */
public interface AccountServiceAdminService extends IService<AccountServiceAdminEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

