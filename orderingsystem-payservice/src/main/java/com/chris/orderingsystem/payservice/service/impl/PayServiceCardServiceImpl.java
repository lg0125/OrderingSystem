package com.chris.orderingsystem.payservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.chris.orderingsystem.payservice.dao.PayServiceCardDao;
import com.chris.orderingsystem.payservice.entity.PayServiceCardEntity;
import com.chris.orderingsystem.payservice.service.PayServiceCardService;


@Service("payServiceCardService")
public class PayServiceCardServiceImpl extends ServiceImpl<PayServiceCardDao, PayServiceCardEntity> implements PayServiceCardService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PayServiceCardEntity> page = this.page(
                new Query<PayServiceCardEntity>().getPage(params),
                new QueryWrapper<PayServiceCardEntity>()
        );

        return new PageUtils(page);
    }

}