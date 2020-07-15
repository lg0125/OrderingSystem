package com.chris.orderingsystem.accountservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.orderingsystem.accountservice.dao.AccountServiceUserAddressDao;
import com.chris.orderingsystem.accountservice.entity.AccountServiceUserAddressEntity;
import com.chris.orderingsystem.accountservice.service.AccountServiceUserAddressService;


@Service("accountServiceUserAddressService")
public class AccountServiceUserAddressServiceImpl extends ServiceImpl<AccountServiceUserAddressDao, AccountServiceUserAddressEntity> implements AccountServiceUserAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AccountServiceUserAddressEntity> page = this.page(
                new Query<AccountServiceUserAddressEntity>().getPage(params),
                new QueryWrapper<AccountServiceUserAddressEntity>()
        );

        return new PageUtils(page);
    }

}