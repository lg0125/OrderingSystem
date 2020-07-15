package com.chris.orderingsystem.accountservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.chris.orderingsystem.accountservice.dao.AccountServiceUserDao;
import com.chris.orderingsystem.accountservice.entity.AccountServiceUserEntity;
import com.chris.orderingsystem.accountservice.service.AccountServiceUserService;


@Service("accountServiceUserService")
public class AccountServiceUserServiceImpl extends ServiceImpl<AccountServiceUserDao, AccountServiceUserEntity> implements AccountServiceUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AccountServiceUserEntity> page = this.page(
                new Query<AccountServiceUserEntity>().getPage(params),
                new QueryWrapper<AccountServiceUserEntity>()
        );

        return new PageUtils(page);
    }

}