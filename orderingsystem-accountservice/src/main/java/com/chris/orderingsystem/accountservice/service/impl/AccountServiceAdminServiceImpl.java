package com.chris.orderingsystem.accountservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.chris.orderingsystem.accountservice.dao.AccountServiceAdminDao;
import com.chris.orderingsystem.accountservice.entity.AccountServiceAdminEntity;
import com.chris.orderingsystem.accountservice.service.AccountServiceAdminService;


@Service("accountServiceAdminService")
public class AccountServiceAdminServiceImpl extends ServiceImpl<AccountServiceAdminDao, AccountServiceAdminEntity> implements AccountServiceAdminService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AccountServiceAdminEntity> page = this.page(
                new Query<AccountServiceAdminEntity>().getPage(params),
                new QueryWrapper<AccountServiceAdminEntity>()
        );

        return new PageUtils(page);
    }

}